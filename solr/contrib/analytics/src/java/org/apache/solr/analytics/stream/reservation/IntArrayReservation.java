/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.solr.analytics.stream.reservation;

import java.io.DataInput;
import java.io.DataOutput;
import java.util.function.IntConsumer;
import java.util.function.IntSupplier;

import org.apache.solr.analytics.stream.reservation.read.IntDataArrayReader;
import org.apache.solr.analytics.stream.reservation.write.IntDataArrayWriter;

public class IntArrayReservation extends ReductionDataArrayReservation<IntConsumer, IntSupplier> {

  public IntArrayReservation(IntConsumer applier, IntConsumer sizeApplier, IntSupplier extractor, IntSupplier sizeExtractor) {
    super(applier, sizeApplier, extractor, sizeExtractor);
  }

  @Override
  public IntDataArrayReader createReadStream(DataInput input) {
    return new IntDataArrayReader(input, applier, sizeApplier);
  }

  @Override
  public IntDataArrayWriter createWriteStream(DataOutput output) {
    return new IntDataArrayWriter(output, extractor, sizeExtractor);
  }
}
