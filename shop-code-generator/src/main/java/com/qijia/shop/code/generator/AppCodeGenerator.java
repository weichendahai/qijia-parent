package com.qijia.shop.code.generator;

import cn.org.rapid_framework.generator.GeneratorFacade;

/**
 * Created by weichen on 2018/9/26.
 */
public class AppCodeGenerator {

	public static void main(String[] args) throws Exception {
		// 模板地址
		String templatePath = "/Users/weichen/work/java_workspace/qijia-parent/shop-code-generator/src/main/resources/template";
		GeneratorFacade g = new GeneratorFacade();
		g.getGenerator().addTemplateRootDir(templatePath);
		// 删除生成器的输出目录//
		g.deleteOutRootDir();
		// 自动搜索数据库中的所有表并生成文件,template为模板的根目录
		g.generateByAllTable();

		/*
			// 删除生成器的输出目录//
			//g.deleteOutRootDir();
			// 通过数据库表生成文件
			g.generateByTable("tb_admin");

			// 自动搜索数据库中的所有表并生成文件,template为模板的根目录
			// g.generateByAllTable();
			// 按table名字删除文件
			// g.deleteByTable("table_name", "template");
		*/
	}
}