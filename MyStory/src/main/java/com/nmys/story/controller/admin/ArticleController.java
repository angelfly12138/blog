package com.nmys.story.controller.admin;

import com.github.pagehelper.PageInfo;
import com.nmys.story.constant.WebConstant;
import com.nmys.story.controller.BaseController;
import com.nmys.story.model.bo.RestResponseBo;
import com.nmys.story.model.dto.Types;
import com.nmys.story.model.entity.Contents;
import com.nmys.story.model.entity.Logs;
import com.nmys.story.model.entity.Metas;
import com.nmys.story.model.entity.Users;
import com.nmys.story.service.IContentService;
import com.nmys.story.service.ILogService;
import com.nmys.story.service.IMetaService;
import com.nmys.story.utils.DateKit;
import com.nmys.story.service.UploadService;
import com.qiniu.common.QiniuException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * Description: 后台文章管理
 * author: hongfei.zhang
 */
@Controller
@RequestMapping("/admin/article")
@Api(value = "后台文章管理Controller")
@Slf4j
public class ArticleController extends BaseController {

    private static final Logger log = LoggerFactory.getLogger(ArticleController.class);

    @Autowired
    private IContentService contentService;

    @Autowired
    private IMetaService metaService;

    @Autowired
    private UploadService uploadService;

    @Autowired
    private ILogService logService;


    /**
     * Description: 文章管理列表
     * author: hongfei.zhang
     */
    @GetMapping(value = "")
    @ApiOperation(value = "后台文章管理列表", notes = "后台文章管理列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "起始页", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "limit", value = "每页条数", required = true, dataType = "Integer")
    })
    public String index(@RequestParam(value = "page", defaultValue = "1") int page,
                        @RequestParam(value = "limit", defaultValue = "10") int limit,
                        @RequestParam(value = "tag", required = false) String tag,
                        @RequestParam(value = "status", required = false) String status,
                        HttpServletRequest request) {
        String flagStatus = null;
        PageInfo<Contents> contentsPaginator = null;
        String article_tag = (String) request.getAttribute("article_tag");
        String article_status = (String) request.getAttribute("article_status");
        if (StringUtils.isNotBlank(article_tag)) {
            tag = article_tag;
        }
        if (StringUtils.isNotBlank(article_status)) {
            status = article_status;
        }
        if (StringUtils.isNotBlank(tag) || StringUtils.isNotBlank(status)) {
            if (StringUtils.isNotBlank(status) && WebConstant.DRAFTCHINESE.equals(status)) {
                flagStatus = WebConstant.DRAFTENGLISG;
            } else {
                flagStatus = status;
            }
            contentsPaginator = contentService.getArticlesByConditions(Types.ARTICLE, tag, flagStatus, page, limit);
            request.setAttribute("article_tag", tag);
            request.setAttribute("article_status", status);
        } else {
            // 根据特定条件来查询文章列表,type = 'post'
            contentsPaginator = contentService.getContentsConditions(Types.ARTICLE, page, limit);
        }
        request.setAttribute("articles", contentsPaginator);
        return "admin/article_list";
    }

    /**
     * Description: 发布文章页面初始化
     * author: hongfei.zhang
     */
    @GetMapping(value = "/publish")
    public String newArticle(HttpServletRequest request) {
        List<Metas> categories = metaService.getMetasByType(Types.CATEGORY);
        List<Metas> tags = metaService.getMetasByType(Types.TAG);
        request.setAttribute("categories", categories);
        request.setAttribute("tags", tags);
        return "admin/article_edit";
    }


    /**
     * Description: 文章发布
     * author: hongfei.zhang
     */
    @PostMapping(value = "/publish")
    @ResponseBody
    public RestResponseBo publishArticle(Contents contents, HttpServletRequest request) {
        // 登录人
        Users users = (Users) SecurityUtils.getSubject().getPrincipal();
        // 作者
        contents.setAuthorId(users.getId());
        // 类型
        contents.setType(Types.ARTICLE);
        if (StringUtils.isBlank(contents.getCategories())) {
            contents.setCategories("默认分类");
        }
        String result = contentService.saveContent(contents);
        if (!WebConstant.SUCCESS_RESULT.equals(result)) {
            return RestResponseBo.fail(result);
        }
        return RestResponseBo.ok();
    }

    /**
     * Description:编辑文章
     * Author:hongfei.zhang
     * Param [cid, request]
     * Return java.lang.String
     */
    @GetMapping(value = "/{cid}")
    @ApiOperation(value = "编辑文章", notes = "后台编辑文章")
    @ApiImplicitParam(name = "cid", value = "文章id", required = true, dataType = "String", paramType = "path")
    public String editArticle(@PathVariable String cid, HttpServletRequest request) {
        Contents contents = contentService.getContentById(Integer.parseInt(cid));
        request.setAttribute("contents", contents);
        List<Metas> categories = metaService.getMetasByType(Types.CATEGORY);
        List<Metas> tags = metaService.getMetasByType(Types.TAG);
        request.setAttribute("categories", categories);
        request.setAttribute("tags", tags);
        request.setAttribute("active", "article");
        return "admin/article_edit";
    }

    /**
     * Description:修改文章
     * Author:hongfei.zhang
     * Param [contents, request]
     * Return com.nmys.story.model.bo.RestResponseBo
     */
    @PostMapping(value = "/modify")
    @ResponseBody
    public RestResponseBo modifyArticle(Contents contents, HttpServletRequest request) {
        // 得到详细信息的文章
        Contents content = contentService.getContentById(contents.getCid());
        Users users = (Users) SecurityUtils.getSubject().getPrincipal();
        String authorId = content.getAuthorId().toString();
        // 非本人禁止修改
        if (!authorId.equals(users.getId().toString())) {
            return RestResponseBo.fail("抱歉，您无此权限！");
        }
        int time = DateKit.getCurrentUnixTime();
        contents.setModified(time);
        contents.setAuthorId(users.getId());
        contents.setType(Types.ARTICLE);
        String result = "";
        boolean flag = contentService.updateContent(contents);
        // 修改文章标签关系表
        contentService.updateRelationsShips(contents.getCid(), contents.getTags(), contents.getCategories());
        if (flag) {
            return RestResponseBo.ok();
        } else {
            result = "文章更新失败!";
            return RestResponseBo.fail(result);
        }
    }

    /**
     * Description: 删除文章
     * Author:hongfei.zhang
     * Param [cid, request]
     * Return RestResponseBo
     */
    @PostMapping(value = "/delete")
    @ResponseBody
    public RestResponseBo delete(@RequestParam int cid, HttpServletRequest request) {
        // 删除文章
        String result = contentService.delContentById(cid);
        if (!WebConstant.SUCCESS_RESULT.equals(result)) {
            return RestResponseBo.fail(result);
        }
        return RestResponseBo.ok();
    }

    /**
     * Description: 图片上传
     * Author:hongfei.zhang
     */
    @RequestMapping(value = "/uploadImage")
    @ResponseBody
    public Map<String, Object> fileUpload(@RequestParam(value = "filedata") MultipartFile file) throws IOException {
        InputStream inputStream = file.getInputStream();
        Map<String, Object> map = uploadService.upload(inputStream);
        try {
            /* 记录日志 */
            Users user = (Users) SecurityUtils.getSubject().getPrincipal();
            Logs log = new Logs();
            log.setAction(WebConstant.USER_ACTION_1);
            log.setAuthor_id(user.getId());
            log.setCreated(DateKit.getCurrentUnixTime());
            log.setData((String) map.get("fileUrl"));
            logService.setUserLog(log);
        } catch (Exception e) {
            log.error("上传图片记录日志出错" + e.getMessage());
        }
        return map;
    }

    /**
     * 删除七牛上的图片
     */
    @RequestMapping(value = "/deletePicture")
    @ResponseBody
    public RestResponseBo deletePicture(@RequestParam("path") String path) {
        try {
            uploadService.deleteQiniuPicByKey(path);

            /* 记录删除日志 */
            Users user = (Users) SecurityUtils.getSubject().getPrincipal();
            Logs logObj = new Logs();
            logObj.setAction(WebConstant.USER_ACTION_2);
            logObj.setAuthor_id(user.getId());
            logObj.setCreated(DateKit.getCurrentUnixTime());
            logObj.setData(path);
            logService.setUserLog(logObj);
            log.info("==========删除七牛图片SUCCESS==========");
            return RestResponseBo.ok();
        } catch (QiniuException e) {
            log.error("==========删除七牛图片FAIL==========" + e.getMessage());
            return RestResponseBo.fail();
        }
    }


}
