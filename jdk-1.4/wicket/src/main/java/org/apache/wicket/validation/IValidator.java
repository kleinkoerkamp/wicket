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
package org.apache.wicket.validation;

import org.apache.wicket.IClusterable;

/**
 * A validator that can validate a {@link IValidatable} object.
 * <p>
 * Unless the validator implements also the {@link INullAcceptingValidator}
 * interface, wicket will not pass null value to the
 * {@link IValidator#validate(IValidatable)} method.
 * 
 * 
 * @author Jonathan Locke
 * @author Igor Vaynberg (ivaynberg)
 */
public interface IValidator extends IClusterable
{
	/**
	 * Validates the <code>validatable</code> object. Validation errors should
	 * be reported using {@link IValidatable#error(IValidationError)} method.
	 * 
	 * @param validatable
	 */
	void validate(IValidatable validatable);
}