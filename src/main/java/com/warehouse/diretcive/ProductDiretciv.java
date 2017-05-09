package com.warehouse.diretcive;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.warehouse.dao.BuildProgressMapper;
import com.warehouse.entity.BuildProgress;

import freemarker.template.TemplateException;

/**
 * Created by Administrator on 2016/8/29.
 */
@Component("ProductDiretciv")
@Resource
public class ProductDiretciv extends BaseDirective {
	@Resource
	private BuildProgressMapper buildProgressMapper;

	@Override
	public void execute(DirectiveHandler handler) throws TemplateException, IOException {
		List<BuildProgress> listProduct = buildProgressMapper.findProduct();
		handler.put("listProduct", listProduct).render();
	}

}
