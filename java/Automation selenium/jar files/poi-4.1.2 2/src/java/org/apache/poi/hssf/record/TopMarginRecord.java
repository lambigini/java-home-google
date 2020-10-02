/* ====================================================================
   Licensed to the Apache Software Foundation (ASF) under one or more
   contributor license agreements.  See the NOTICE file distributed with
   this work for additional information regarding copyright ownership.
   The ASF licenses this file to You under the Apache License, Version 2.0
   (the "License"); you may not use this file except in compliance with
   the License.  You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
==================================================================== */

package org.apache.poi.hssf.record;

import org.apache.poi.util.LittleEndianOutput;
import org.apache.poi.util.Removal;

/**
 * Record for the top margin.
 */
public final class TopMarginRecord extends StandardRecord implements Margin {
    public static final short sid = 0x28;

    private double field_1_margin;

    public TopMarginRecord() {}

    public TopMarginRecord(TopMarginRecord other) {
        super(other);
        field_1_margin = other.field_1_margin;
    }

    /**
     * @param in the RecordInputstream to read the record from
     */
    public TopMarginRecord( RecordInputStream in ) {
        field_1_margin = in.readDouble();
    }

    public String toString()
    {
        StringBuilder buffer = new StringBuilder();
        buffer.append( "[TopMargin]\n" );
        buffer.append( "    .margin               = " ).append( " (" ).append( getMargin() ).append( " )\n" );
        buffer.append( "[/TopMargin]\n" );
        return buffer.toString();
    }

    public void serialize(LittleEndianOutput out) {
        out.writeDouble(field_1_margin);
    }

    protected int getDataSize() {
        return 8;
    }

    public short getSid()    {        return sid;    }

    /**
     * Get the margin field for the TopMargin record.
     */
    public double getMargin()    {        return field_1_margin;    }

    /**
     * Set the margin field for the TopMargin record.
     */
    public void setMargin( double field_1_margin )
    {        this.field_1_margin = field_1_margin;    }

    @Override
    @SuppressWarnings("squid:S2975")
    @Deprecated
    @Removal(version = "5.0.0")
    public TopMarginRecord clone() {
        return copy();
    }

    @Override
    public TopMarginRecord copy() {
        return new TopMarginRecord(this);
    }
}