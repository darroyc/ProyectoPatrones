package com.sistemacompras;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.testsMultis.MDepartamentoTest;
import com.testsMultis.MTramiteTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    MDepartamentoTest.class,
    MTramiteTest.class
})

public class SuiteTest {

}

