package com.quorum.tessera.p2p.model;

import com.openpojo.reflection.impl.PojoClassFactory;
import com.openpojo.validation.Validator;
import com.openpojo.validation.ValidatorBuilder;
import com.openpojo.validation.rule.impl.GetterMustExistRule;
import com.openpojo.validation.rule.impl.SetterMustExistRule;
import com.openpojo.validation.test.impl.GetterTester;
import com.openpojo.validation.test.impl.SetterTester;
import org.junit.Test;

public class OpenPojoTest {

    @Test
    public void test() {

        final Validator validator = ValidatorBuilder.create()
            .with(new GetterMustExistRule())
            .with(new SetterMustExistRule())
            .with(new SetterTester())
            .with(new GetterTester())
            .build();

        validator.validate(PojoClassFactory.getPojoClasses(GetPartyInfoResponse.class.getPackage().getName()));
    }

}
