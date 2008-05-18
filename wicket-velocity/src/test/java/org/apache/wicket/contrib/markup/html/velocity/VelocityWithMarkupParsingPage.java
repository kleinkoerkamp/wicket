/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.wicket.contrib.markup.html.velocity;

import java.util.HashMap;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.resource.IStringResourceStream;
import org.apache.wicket.util.resource.UrlResourceStream;
import org.apache.wicket.velocity.markup.html.VelocityPanel;

/**
 * Test page for <code>VelocityPanel</code>
 * 
 * @see org.apache.wicket.velocity.markup.html.VelocityPanel
 */
public class VelocityWithMarkupParsingPage extends WebPage<Void>
{
	/**
	 * Adds a VelocityPanel to the page with markup parsing
	 */
	public VelocityWithMarkupParsingPage()
	{
		HashMap<String, String> values = new HashMap<String, String>();
		values.put("labelId", "message");
		VelocityPanel velocityPanel = new VelocityPanel("velocityPanel",
				new Model<HashMap<String, String>>(values))
		{
			private static final long serialVersionUID = 1L;

			@Override
			protected IStringResourceStream getTemplateResource()
			{
				return new UrlResourceStream(getClass().getResource("testWithMarkup.html"));
			}

			@Override
			public boolean parseGeneratedMarkup()
			{
				return true;
			}
		};
		velocityPanel.add(new Label<String>("message", VelocityPage.TEST_STRING)
		{
			@Override
			protected void onComponentTag(ComponentTag tag)
			{
				super.onComponentTag(tag);
				// check whether the markupstream can be located
				getMarkupAttributes();
			}
		});
		add(velocityPanel);
	}
}