/*
 * Copyright (C) 2012 The Libphonenumber Authors
 * Copyright (C) 2016 Michael Rozumyanskiy
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
 */

package io.michaelrocks.libphonenumber.android;

import junit.framework.TestCase;

/**
 * Root class for PhoneNumberUtil tests that depend on the test metadata file.
 * <p>
 * Note since tests that extend this class do not use the normal metadata file, they should not be
 * used for regression test purposes.
 *
 * @author Shaopeng Jia
 */
public abstract class TestMetadataTestCase extends TestCase {
  private static final String TEST_META_DATA_FILE_PREFIX =
      "/io/michaelrocks/libphonenumber/android/data/PhoneNumberMetadataProtoForTesting";
  private static final String TEST_ALTERNATE_FORMATS_FILE_PREFIX =
      "/io/michaelrocks/libphonenumber/android/data/PhoneNumberAlternateFormatsProto";
  private static final String TEST_SHORT_NUMBER_METADATA_FILE_PREFIX =
      "/io/michaelrocks/libphonenumber/android/data/ShortNumberMetadataProto";

  protected final PhoneNumberUtil phoneUtil;

  public TestMetadataTestCase() {
    phoneUtil = initializePhoneUtilForTesting();
  }

  static PhoneNumberUtil initializePhoneUtilForTesting() {
    PhoneNumberUtil phoneUtil = new PhoneNumberUtil(
        new MultiFileMetadataSourceImpl(
            TEST_META_DATA_FILE_PREFIX, TEST_ALTERNATE_FORMATS_FILE_PREFIX, TEST_SHORT_NUMBER_METADATA_FILE_PREFIX,
            new ResourceMetadataLoader(TestMetadataTestCase.class)),
        CountryCodeToRegionCodeMapForTesting.getCountryCodeToRegionCodeMap());
    return phoneUtil;
  }
}
