/**
 * Copyright (C) 2012 - 2013 Xeiam LLC http://xeiam.com
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is furnished to do
 * so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.xeiam.xchange.btce.service.marketdata;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

import com.xeiam.xchange.btce.dto.marketdata.BTCETicker;

/**
 * Test BTCETicker JSON parsing
 */
public class BTCETickerJSONTest {

  @Test
  public void testUnmarshal() throws IOException {

    // Read in the JSON from the example resources
    InputStream is = BTCETickerJSONTest.class.getResourceAsStream("/marketdata/example-ticker-data.json");

    // Use Jackson to parse it
    ObjectMapper mapper = new ObjectMapper();
    BTCETicker BTCETicker = mapper.readValue(is, BTCETicker.class);

    // Verify that the example data was unmarshalled correctly
    assertThat("Unexpected Return Last value", BTCETicker.getTicker().getLast(), equalTo(new BigDecimal("13.07")));
    assertThat("Unexpected Return High value", BTCETicker.getTicker().getHigh(), equalTo(new BigDecimal("13.23")));
    assertThat("Unexpected Return Low value", BTCETicker.getTicker().getLow(), equalTo(new BigDecimal("13")));
    assertThat("Unexpected Return Volume value", BTCETicker.getTicker().getVol(), equalTo(new BigDecimal("40418.44988")));
  }

}
