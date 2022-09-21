package org.jeecg.modules.cms.sys.mxy.controller;

import java.io.UnsupportedEncodingException;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.def.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.view.JeecgEntityExcelView;
import org.jeecg.common.system.vo.LoginUser;
import org.apache.shiro.SecurityUtils;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.common.util.oConvertUtils;
import org.jeecg.modules.cms.sys.mxy.entity.MxyComicChapter;
import org.jeecg.modules.cms.sys.mxy.entity.MxyComic;
import org.jeecg.modules.cms.sys.mxy.vo.MxyComicPage;
import org.jeecg.modules.cms.sys.mxy.service.IMxyComicService;
import org.jeecg.modules.cms.sys.mxy.service.IMxyComicChapterService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jeecg.common.aspect.annotation.AutoLog;

 /**
 * @Description: 漫画列表
 * @Author: jeecg-boot
 * @Date:   2022-09-21
 * @Version: V1.0
 */
@Api(tags="漫画列表")
@RestController
@RequestMapping("/mxy/mxyComic")
@Slf4j
public class MxyComicController {
	@Autowired
	private IMxyComicService mxyComicService;
	@Autowired
	private IMxyComicChapterService mxyComicChapterService;
	
	/**
	 * 分页列表查询
	 *
	 * @param mxyComic
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "漫画列表-分页列表查询")
	@ApiOperation(value="漫画列表-分页列表查询", notes="漫画列表-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<MxyComic>> queryPageList(MxyComic mxyComic,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<MxyComic> queryWrapper = QueryGenerator.initQueryWrapper(mxyComic, req.getParameterMap());
		Page<MxyComic> page = new Page<MxyComic>(pageNo, pageSize);
		IPage<MxyComic> pageList = mxyComicService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param mxyComicPage
	 * @return
	 */
	@AutoLog(value = "漫画列表-添加")
	@ApiOperation(value="漫画列表-添加", notes="漫画列表-添加")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody MxyComicPage mxyComicPage) {
		MxyComic mxyComic = new MxyComic();
		BeanUtils.copyProperties(mxyComicPage, mxyComic);
		mxyComicService.saveMain(mxyComic, mxyComicPage.getMxyComicChapterList());
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param mxyComicPage
	 * @return
	 */
	@AutoLog(value = "漫画列表-编辑")
	@ApiOperation(value="漫画列表-编辑", notes="漫画列表-编辑")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody MxyComicPage mxyComicPage) {
		MxyComic mxyComic = new MxyComic();
		BeanUtils.copyProperties(mxyComicPage, mxyComic);
		MxyComic mxyComicEntity = mxyComicService.getById(mxyComic.getId());
		if(mxyComicEntity==null) {
			return Result.error("未找到对应数据");
		}
		mxyComicService.updateMain(mxyComic, mxyComicPage.getMxyComicChapterList());
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "漫画列表-通过id删除")
	@ApiOperation(value="漫画列表-通过id删除", notes="漫画列表-通过id删除")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		mxyComicService.delMain(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "漫画列表-批量删除")
	@ApiOperation(value="漫画列表-批量删除", notes="漫画列表-批量删除")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.mxyComicService.delBatchMain(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功！");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "漫画列表-通过id查询")
	@ApiOperation(value="漫画列表-通过id查询", notes="漫画列表-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<MxyComic> queryById(@RequestParam(name="id",required=true) String id) {
		MxyComic mxyComic = mxyComicService.getById(id);
		if(mxyComic==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(mxyComic);

	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "漫画章节列表通过主表ID查询")
	@ApiOperation(value="漫画章节列表主表ID查询", notes="漫画章节列表-通主表ID查询")
	@GetMapping(value = "/queryMxyComicChapterByMainId")
	public Result<List<MxyComicChapter>> queryMxyComicChapterListByMainId(@RequestParam(name="id",required=true) String id) {
		List<MxyComicChapter> mxyComicChapterList = mxyComicChapterService.selectByMainId(id);
		return Result.OK(mxyComicChapterList);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param mxyComic
    */
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, MxyComic mxyComic) {
      // Step.1 组装查询条件查询数据
      QueryWrapper<MxyComic> queryWrapper = QueryGenerator.initQueryWrapper(mxyComic, request.getParameterMap());
      LoginUser sysUser = (LoginUser) SecurityUtils.getSubject().getPrincipal();

      //配置选中数据查询条件
      String selections = request.getParameter("selections");
      if(oConvertUtils.isNotEmpty(selections)) {
         List<String> selectionList = Arrays.asList(selections.split(","));
         queryWrapper.in("id",selectionList);
      }
      //Step.2 获取导出数据
      List<MxyComic> mxyComicList = mxyComicService.list(queryWrapper);

      // Step.3 组装pageList
      List<MxyComicPage> pageList = new ArrayList<MxyComicPage>();
      for (MxyComic main : mxyComicList) {
          MxyComicPage vo = new MxyComicPage();
          BeanUtils.copyProperties(main, vo);
          List<MxyComicChapter> mxyComicChapterList = mxyComicChapterService.selectByMainId(main.getId());
          vo.setMxyComicChapterList(mxyComicChapterList);
          pageList.add(vo);
      }

      // Step.4 AutoPoi 导出Excel
      ModelAndView mv = new ModelAndView(new JeecgEntityExcelView());
      mv.addObject(NormalExcelConstants.FILE_NAME, "漫画列表列表");
      mv.addObject(NormalExcelConstants.CLASS, MxyComicPage.class);
      mv.addObject(NormalExcelConstants.PARAMS, new ExportParams("漫画列表数据", "导出人:"+sysUser.getRealname(), "漫画列表"));
      mv.addObject(NormalExcelConstants.DATA_LIST, pageList);
      return mv;
    }

    /**
    * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
      MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
      Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
      for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
          // 获取上传文件对象
          MultipartFile file = entity.getValue();
          ImportParams params = new ImportParams();
          params.setTitleRows(2);
          params.setHeadRows(1);
          params.setNeedSave(true);
          try {
              List<MxyComicPage> list = ExcelImportUtil.importExcel(file.getInputStream(), MxyComicPage.class, params);
              for (MxyComicPage page : list) {
                  MxyComic po = new MxyComic();
                  BeanUtils.copyProperties(page, po);
                  mxyComicService.saveMain(po, page.getMxyComicChapterList());
              }
              return Result.OK("文件导入成功！数据行数:" + list.size());
          } catch (Exception e) {
              log.error(e.getMessage(),e);
              return Result.error("文件导入失败:"+e.getMessage());
          } finally {
              try {
                  file.getInputStream().close();
              } catch (IOException e) {
                  e.printStackTrace();
              }
          }
      }
      return Result.OK("文件导入失败！");
    }

}
