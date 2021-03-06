/*
 * Copyright 2015 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.drools.workbench.screens.guided.dtable.client.widget.table.columns;

import java.util.List;

import com.ait.lienzo.client.core.shape.Text;
import org.drools.workbench.screens.guided.dtable.client.widget.table.GuidedDecisionTablePresenter;
import org.drools.workbench.screens.guided.dtable.client.widget.table.columns.dom.textbox.TextBoxByteSingletonDOMElementFactory;
import org.drools.workbench.screens.guided.dtable.client.widget.table.columns.dom.textbox.TextBoxDOMElement;
import org.uberfire.client.callbacks.Callback;
import org.uberfire.ext.widgets.common.client.common.NumericByteTextBox;
import org.uberfire.ext.wires.core.grids.client.model.GridCell;
import org.uberfire.ext.wires.core.grids.client.model.GridCellValue;
import org.uberfire.ext.wires.core.grids.client.widget.context.GridBodyCellRenderContext;

public class ByteUiColumn extends BaseUiSingletonColumn<Byte, NumericByteTextBox, TextBoxDOMElement<Byte, NumericByteTextBox>, TextBoxByteSingletonDOMElementFactory> {

    public ByteUiColumn( final List<HeaderMetaData> headerMetaData,
                         final double width,
                         final boolean isResizable,
                         final boolean isVisible,
                         final GuidedDecisionTablePresenter.Access access,
                         final TextBoxByteSingletonDOMElementFactory factory ) {
        super( headerMetaData,
               new CellRenderer<Byte, NumericByteTextBox, TextBoxDOMElement<Byte, NumericByteTextBox>>( factory ) {
                   @Override
                   protected void doRenderCellContent( final Text t,
                                                       final Byte value,
                                                       final GridBodyCellRenderContext context ) {
                       t.setText( ( (TextBoxByteSingletonDOMElementFactory) factory ).convert( value ) );
                   }
               },
               width,
               isResizable,
               isVisible,
               access,
               factory );
    }

    @Override
    public void doEdit( final GridCell<Byte> cell,
                        final GridBodyCellRenderContext context,
                        final Callback<GridCellValue<Byte>> callback ) {
        factory.attachDomElement( context,
                                  CallbackFactory.makeOnCreationCallback( factory,
                                                                          cell ),
                                  CallbackFactory.makeOnDisplayTextBoxCallback() );
    }

}
