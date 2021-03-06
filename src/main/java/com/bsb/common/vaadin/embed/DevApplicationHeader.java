/*
 * Copyright 2006-2007 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.bsb.common.vaadin.embed;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.themes.BaseTheme;

/**
 * A header added to an application to offer various development-related tools.
 *
 * @author Stephane Nicoll
 */
public class DevApplicationHeader extends HorizontalLayout {


    public DevApplicationHeader(final EmbedVaadinServer server) {
        final Button shutdown = new Button("shutdown");
        shutdown.setStyleName(BaseTheme.BUTTON_LINK);
        shutdown.setDescription("Shutdown the embed server and close this tab");
        addComponent(shutdown);
        setComponentAlignment(shutdown, Alignment.MIDDLE_CENTER);


        shutdown.addListener(new Button.ClickListener() {
            public void buttonClick(Button.ClickEvent event) {
                server.stop();
                // Close the browser tab
                getWindow().executeJavaScript("close();");
            }
        });
    }
}
