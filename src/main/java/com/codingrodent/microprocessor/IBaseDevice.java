/*
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
package com.codingrodent.microprocessor;

/**
 * Interface to describe the I/O processor bus
 */
public interface IBaseDevice {

    /**
     * Read data from an I/O port
     *
     * @param address The address contains the full 16-bit address
     *                The port to be read from is contained in the lower 8 bits
     * @return The 8 bit value at the request port address
     */
    default int IORead(int address) {
        return 0;
    }

    /**
     * Write data to an I/O port
     *
     * @param address The address contains the full 16-bit address
     *                The port to be read from is contained in the lower 8 bits
     * @param data    The 8 bit value to be written
     */
    default void IOWrite(int address, int data) {
        // do nothing
    }

    /**
     * Get the interrupt vector byte for interrupt mode 0 and 2
     *
     * For IM 0: Returns the instruction to be executed (typically RST instruction 0xC7-0xFF)
     * For IM 2: Returns the low byte of the interrupt vector table address
     *           Combined with I register: address = (I &lt;&lt; 8) | getInterruptVector()
     *
     * @return The 8 bit interrupt vector value from the interrupting device
     */
    default int getInterruptVector() {
        return 0xFF; // Default to RST 38h for IM 0, or 0xFF for IM 2
    }
}
