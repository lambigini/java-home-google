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
 * Tells whether to center the sheet between vertical margins
 *
 * @version 2.0-pre
 */

public final class VCenterRecord extends StandardRecord {
    public static final short sid = 0x84;
    private int field_1_vcenter;

    public VCenterRecord() {}

    public VCenterRecord(VCenterRecord other) {
        super(other);
        field_1_vcenter = other.field_1_vcenter;
    }

    public VCenterRecord(RecordInputStream in) {
        field_1_vcenter = in.readShort();
    }

    /**
     * set whether to center vertically or not
     * @param hc  vcenter or not
     */

    public void setVCenter(boolean hc)
    {
    	field_1_vcenter = hc ? 1 : 0;
    }

    /**
     * get whether to center vertically or not
     * @return vcenter or not
     */

    public boolean getVCenter()
    {
        return (field_1_vcenter == 1);
    }

    public String toString()
    {
        StringBuilder buffer = new StringBuilder();

        buffer.append("[VCENTER]\n");
        buffer.append("    .vcenter        = ").append(getVCenter())
            .append("\n");
        buffer.append("[/VCENTER]\n");
        return buffer.toString();
    }

    public void serialize(LittleEndianOutput out) {
        out.writeShort(field_1_vcenter);
    }

    protected int getDataSize() {
        return 2;
    }

    public short getSid()
    {
        return sid;
    }

    @Override
    @SuppressWarnings("squid:S2975")
    @Deprecated
    @Removal(version = "5.0.0")
    public VCenterRecord clone() {
        return copy();
    }

    @Override
    public VCenterRecord copy() {
      return new VCenterRecord(this);
    }
}
