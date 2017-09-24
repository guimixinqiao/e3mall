package cn.e3mall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.e3mall.mapper.TbItemMapper;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.pojo.TbItemExample;
import cn.e3mall.pojo.TbItemExample.Criteria;
import cn.e3mall.service.ItemService;
 /**
  * 商品管理Service
  * @author dell
  *
  */
@Service
public class ItemServiceImpl implements ItemService{
	
	@Autowired 
	private TbItemMapper itemMapper;
	@Override
	public TbItem getItemById(long id) {
		//根据商品ID来查询商品信息
		//itemMapper.selectByPrimaryKey(id); 这个也可以用
		TbItemExample example=new TbItemExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(id);
		//执行查询
		List<TbItem> list = itemMapper.selectByExample(example);
		if(list!=null && list.size()>0) {
			TbItem item=list.get(0);
			return item;
		}
		
		return null;
	}

}
