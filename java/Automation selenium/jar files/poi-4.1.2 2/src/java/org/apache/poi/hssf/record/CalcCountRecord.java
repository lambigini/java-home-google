
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
 * Specifies the maximum times the gui should perform a formula recalculation.
 * For instance: in the case a formula includes cells that are themselves a result of a formula and
 * a value changes.  This is essentially a failsafe against an infinite loop in the event the formulas
 * are not independent.
 *
 * @version 2.0-pre
 * @see CalcModeRecord
 */

public final class CalcCountRecord extends StandardRecord {
    public static final short sid = 0xC;

    private short field_1_iterations;

    public CalcCountRecord() {}

    public CalcCountRecord(CalcCountRecord other) {
        super(other);
        field_1_iterations = other.field_1_iterations;
    }


    public CalcCountRecord(RecordInputStream in) {
        field_1_iterations = in.readShort();
    }

    /**
     * set the number of iterations to perform
     * @param iterations to perform
     */

    public void setIterations(short iterations)
    {
        field_1_iterations = iterations;
    }

    /**
     * get the number of iterations to perform
     * @return iterations
     */

    public short getIterations()
    {
        return field_1_iterations;
    }

    public String toString()
    {
        StringBuilder buffer = new StringBuilder();

        buffer.append("[CALCCOUNT]\n");
        buffer.append("    .iterations     = ")
            .append(Integer.toHexString(getIterations())).append("\n");
        buffer.append("[/CALCCOUNT]\n");
        return buffer.toString();
    }

    public void serialize(LittleEndianOutput out) {
        out.writeShort(getIterations());
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
    public CalcCountRecord clone() {
        return copy();
    }

    @Override
    public CalcCountRecord copy() {
        return new CalcCountRecord(this);
    }
}
