/*
 * Copyright 2015 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.drools.workbench.screens.guided.dtable.client.widget.table.columns.dom.textbox;

import java.math.BigDecimal;

import org.drools.workbench.screens.guided.dtable.client.widget.table.GuidedDecisionTableView;
import org.uberfire.ext.widgets.common.client.common.NumericBigDecimalTextBox;
import org.uberfire.ext.wires.core.grids.client.widget.layer.GridLayer;

public class TextBoxNumericSingletonDOMElementFactory extends TextBoxSingletonDOMElementFactory<Number, NumericBigDecimalTextBox> {

    public TextBoxNumericSingletonDOMElementFactory( final GridLayer gridLayer,
                                                     final GuidedDecisionTableView gridWidget ) {
        super( gridLayer,
               gridWidget );
    }

    @Override
    public NumericBigDecimalTextBox createWidget() {
        return new NumericBigDecimalTextBox( true );
    }

    @Override
    public String convert( final Number value ) {
        if ( value == null ) {
            return "";
        }
        return value.toString();
    }

    @Override
    public BigDecimal convert( final String value ) {
        return new BigDecimal( value );
    }

}
