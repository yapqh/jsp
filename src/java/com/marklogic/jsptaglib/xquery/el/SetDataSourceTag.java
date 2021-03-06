/*
 * Copyright (c)2004 Mark Logic Corporation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * The use of the Apache License does not indicate that this project is
 * affiliated with the Apache Software Foundation.
 */
package com.marklogic.jsptaglib.xquery.el;

import org.apache.taglibs.standard.lang.support.ExpressionEvaluatorManager;

import javax.servlet.jsp.JspException;


/**
 * @jsp:tag name="setDataSource" body-content="JSP"
 * description="Set DataSource, Expression Language capable."
 * @see com.marklogic.jsptaglib.xquery.rt.SetDataSourceTag
 * @author Ron Hitchens (ron.hitchens@marklogic.com)
 */
public class SetDataSourceTag extends com.marklogic.jsptaglib.xquery.rt.SetDataSourceTag
{
	/**
	 * @jsp:attribute required="false" rtexprvalue="false"
	 */
	public void setVar (String var) throws JspException
	{
		super.setVar ((String) ExpressionEvaluatorManager.evaluate ("var", var, String.class, this, pageContext));
	}

	/**
	 * @jsp:attribute required="false" rtexprvalue="false"
	 */
	public void setScope (String scope) throws JspException
	{
		super.setScope ((String) ExpressionEvaluatorManager.evaluate ("scope", scope, String.class, this, pageContext));
	}

	/**
	 * @jsp:attribute required="false" rtexprvalue="false"
	 */
	public void setDataSource (String dataSource) throws JspException
	{
		super.setDataSource (ExpressionEvaluatorManager.evaluate ("dataSource", dataSource, Object.class, this, pageContext));
	}

	/**
	 * @jsp:attribute required="false" rtexprvalue="false"
	 */
	public void setHost (String host) throws JspException
	{
		super.setHost ((String) ExpressionEvaluatorManager.evaluate ("host", host, String.class, this, pageContext));
	}

	/**
	 * @jsp:attribute required="false" rtexprvalue="false"
	 */
	public void setPort (String port) throws JspException
	{
		super.setPort (((Integer) ExpressionEvaluatorManager.evaluate ("port", port, Integer.class, this, pageContext)).intValue());
	}

	/**
	 * @jsp:attribute required="false" rtexprvalue="false"
	 */
	public void setUser (String user) throws JspException
	{
		super.setUser ((String) ExpressionEvaluatorManager.evaluate ("user", user, String.class, this, pageContext));
	}

	/**
	 * @jsp:attribute required="false" rtexprvalue="false"
	 */
	public void setPassword (String password) throws JspException
	{
		super.setPassword ((String) ExpressionEvaluatorManager.evaluate ("password", password, String.class, this, pageContext));
	}
}
