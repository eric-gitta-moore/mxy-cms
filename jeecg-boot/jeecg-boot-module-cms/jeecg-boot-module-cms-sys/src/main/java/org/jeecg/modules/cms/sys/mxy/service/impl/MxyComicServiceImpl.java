package org.jeecg.modules.cms.sys.mxy.service.impl;

import org.jeecg.modules.cms.sys.mxy.entity.MxyComic;
import org.jeecg.modules.cms.sys.mxy.entity.MxyComicChapter;
import org.jeecg.modules.cms.sys.mxy.mapper.MxyComicChapterMapper;
import org.jeecg.modules.cms.sys.mxy.mapper.MxyComicMapper;
import org.jeecg.modules.cms.sys.mxy.service.IMxyComicService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.io.Serializable;
import java.util.List;
import java.util.Collection;

/**
 * @Description: 漫画列表
 * @Author: jeecg-boot
 * @Date:   2022-09-21
 * @Version: V1.0
 */
@Service
public class MxyComicServiceImpl extends ServiceImpl<MxyComicMapper, MxyComic> implements IMxyComicService {

	@Autowired
	private MxyComicMapper mxyComicMapper;
	@Autowired
	private MxyComicChapterMapper mxyComicChapterMapper;
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void saveMain(MxyComic mxyComic, List<MxyComicChapter> mxyComicChapterList) {
		mxyComicMapper.insert(mxyComic);
		if(mxyComicChapterList!=null && mxyComicChapterList.size()>0) {
			for(MxyComicChapter entity:mxyComicChapterList) {
				//外键设置
				entity.setComicId(mxyComic.getId());
				mxyComicChapterMapper.insert(entity);
			}
		}
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void updateMain(MxyComic mxyComic,List<MxyComicChapter> mxyComicChapterList) {
		mxyComicMapper.updateById(mxyComic);
		
		//1.先删除子表数据
		mxyComicChapterMapper.deleteByMainId(mxyComic.getId());
		
		//2.子表数据重新插入
		if(mxyComicChapterList!=null && mxyComicChapterList.size()>0) {
			for(MxyComicChapter entity:mxyComicChapterList) {
				//外键设置
				entity.setComicId(mxyComic.getId());
				mxyComicChapterMapper.insert(entity);
			}
		}
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void delMain(String id) {
		mxyComicChapterMapper.deleteByMainId(id);
		mxyComicMapper.deleteById(id);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void delBatchMain(Collection<? extends Serializable> idList) {
		for(Serializable id:idList) {
			mxyComicChapterMapper.deleteByMainId(id.toString());
			mxyComicMapper.deleteById(id);
		}
	}
	
}
