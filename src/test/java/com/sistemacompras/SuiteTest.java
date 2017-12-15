package com.sistemacompras;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.TestsMultis.MDepartamentoTest;
import com.TestsMultis.MTramiteTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    MDepartamentoTest.class,
    MTramiteTest.class
})

public class SuiteTest {

}

