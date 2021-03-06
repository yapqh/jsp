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
package com.marklogic.jsptaglib.xquery.rt;

import com.marklogic.jsptaglib.TagPropertyHelper;
import com.marklogic.jsptaglib.xquery.common.ConnectionProperties;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

/**
 * @jsp:tag name="host"
 *  description="Set parent attribute to the value of the body of this tag"
 * @author Ron Hitchens (ron.hitchens@marklogic.com)
 */
public class HostTag extends BodyTagSupport
{
	private String host = null;

	/**
	 * @jsp:attribute required="false" rtexprvalue="true"
	 */
	public void setInitParameter (String parameterName) throws JspException
	{
		host = pageContext.getServletContext().getInitParameter (parameterName);
	}

	// -----------------------------------------------------------

	public int doEndTag () throws JspException
	{
		if (host == null) {
			host = getBodyContent().getString().trim();
		}

		TagPropertyHelper.assignAncestorProperty (this, ConnectionProperties.class, "host", host);

		return EVAL_PAGE;
	}

	public void release ()
	{
		host = null;
	}
}
