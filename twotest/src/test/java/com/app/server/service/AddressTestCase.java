package com.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.AddressRepository;
import com.app.shared.location.Address;
import org.springframework.beans.factory.annotation.Autowired;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import com.athena.framework.server.helper.EntityValidatorHelper;
import com.athena.framework.server.test.RandomValueGenerator;
import java.util.HashMap;
import com.spartan.healthmeter.entity.scheduler.ArtMethodCallStack;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.junit.Before;
import org.junit.After;
import com.athena.framework.shared.entity.web.entityInterface.CommonEntityInterface.RECORD_TYPE;
import org.junit.Test;
import com.app.shared.location.AddressType;
import com.app.server.repository.AddressTypeRepository;
import com.app.shared.location.City;
import com.app.server.repository.CityRepository;
import com.app.shared.location.Country;
import com.app.server.repository.CountryRepository;
import com.app.shared.location.State;
import com.app.server.repository.StateRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class AddressTestCase {

    @Autowired
    private AddressRepository<Address> addressRepository;

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private EntityValidatorHelper<Object> entityValidator;

    private RandomValueGenerator valueGenerator = new RandomValueGenerator();

    private static HashMap<String, Object> map = new HashMap<String, Object>();

    @Autowired
    private ArtMethodCallStack methodCallStack;

    protected MockHttpSession session;

    protected MockHttpServletRequest request;

    protected MockHttpServletResponse response;

    protected void startSession() {
        session = new MockHttpSession();
    }

    protected void endSession() {
        session.clearAttributes();
        session.invalidate();
        session = null;
    }

    protected void startRequest() {
        request = new MockHttpServletRequest();
        request.setSession(session);
        org.springframework.web.context.request.RequestContextHolder.setRequestAttributes(new org.springframework.web.context.request.ServletRequestAttributes(request));
    }

    protected void endRequest() {
        ((org.springframework.web.context.request.ServletRequestAttributes) org.springframework.web.context.request.RequestContextHolder.getRequestAttributes()).requestCompleted();
        org.springframework.web.context.request.RequestContextHolder.resetRequestAttributes();
        request = null;
    }

    @Before
    public void before() {
        startSession();
        startRequest();
        setBeans();
    }

    @After
    public void after() {
        endSession();
        endRequest();
    }

    private void setBeans() {
        runtimeLogInfoHelper.createRuntimeLogUserInfo(1, "AAAAA", request.getRemoteHost());
        org.junit.Assert.assertNotNull(runtimeLogInfoHelper);
        methodCallStack.setRequestId(java.util.UUID.randomUUID().toString().toUpperCase());
    }

    @Test
    public void test1Save() {
        try {
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("HpmCLAO0oE8sg98qXzImbkbtV6luFpkGyHxzFiDfYIteU8iVOP");
            addresstype.setAddressTypeDesc("KHY8aJ5qus6WGQQKufFKlhnVvvOFfpcUSe8mVmjt1pDunkwQ8S");
            addresstype.setAddressTypeIcon("rIycGTOVOiG9qWszfAQ2sCHHDidQPLiPrDpavlEldkButVEMvM");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(0);
            city.setCityCodeChar2("oVFdeqbXquv2ejJz5nUtiSzA3gLe8LPC");
            city.setCityDescription("Tr7JAA3Thq5lAavtfNAPXTz9D7Sd0TQz1yY27EUHzyRxhEsUxI");
            city.setCityFlag("ZRukhubmJsiyg3rK7cXb8QH0UZvdQQpoZDszqUVg6fcTojqvsG");
            city.setCityLatitude(8);
            city.setCityLongitude(11);
            city.setCityName("u2e5hqFCKGcIDZBBFmkdWecsY2ZGrYcowgifnizp3hsHVVo0lE");
            Country country = new Country();
            country.setCapital("YXwfTOUgtC6424lxWLofRyfr6lUn5Xmu");
            country.setCapitalLatitude(8);
            country.setCapitalLongitude(4);
            country.setCountryCode1("34P");
            country.setCountryCode2("a3I");
            country.setCountryFlag("tZIdkrpwdpSm81oqpkR54M8uNjULjMveycvx1SZcBD8pi362uy");
            country.setCountryName("FjqzdhtYFvQstdzzeejckV4rQKngLCon3okNSja38kFghUdZar");
            country.setCurrencyCode("EB4");
            country.setCurrencyName("fZS0h52JkDSZtprDO030G9cX3Cy7UjlaxLjhW5WtdAxBBTTdRC");
            country.setCurrencySymbol("Xx4urfErQLQc54cPkeVDM8mxSm6tM7hU");
            country.setIsoNumeric(6);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("JSquUe6D79X0eRyLshERmmaIPonxLhtMGOglJhaXRezHC6cUbu");
            state.setStateCapitalLatitude(8);
            state.setStateCapitalLongitude(3);
            state.setStateCode(2);
            state.setStateCodeChar2("hr3eO2oXHOrMS37uv8Gl3S76NyWL7qK4");
            state.setStateCodeChar3("554Zwn4WgbHQec8pJR7kORlHrLzqRM3P");
            state.setStateDescription("cEdrYMdGlMIYN90eSdlS5ZPObsQETKfIogSrhzdChWsTckcQts");
            state.setStateFlag("fZZ5dRjrqUO3H9MkfdzVIr5cOhJkUKMP9MpKZxtCOdMXhMutLn");
            state.setStateName("k2y9Vyz16VSVV4bYDUTPGH2Hqs1K4rLPqpEynGRR9RW99PXqHa");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(3);
            city.setCityCodeChar2("1cJlrwoHzGgnbIw5pLqGnw94piDX2yI6");
            city.setCityDescription("hIeH2SVXtutyMy2nrRF45U4Qro8hzhcV0xSeZclOVZz61ugyWK");
            city.setCityFlag("S0zXg7p2iLSveBsPdBHi62henyt0hgePza69MpmTGYLaI757Ft");
            city.setCityLatitude(2);
            city.setCityLongitude(1);
            city.setCityName("xGz91SemIa5tVlrgIKikeDpveHSqpHWTuHRZQGIDnJOFlf99Z7");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            Address address = new Address();
            address.setAddress1("hwEEN6a0SQYKgcYcDzOCl4gC1EmQ0ec8zLNrVCRspc9ZSkFdRR");
            address.setAddress2("ihldB0b1ZPPecnqXgixR8CZ5mzLac00c2z7V1TGZYc40RULvZU");
            address.setAddress3("nfLrXKPyd0ZWR6rsIGJrwTZlxy8zlPAxozRMADpTYab0Dk46v7");
            address.setAddressLabel("QDQQ8p9ILoa");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("Fw7ytI5r2gZSzL6jyCKU6N7nk7c2ub8OUTwtiPltbSV6XTDVSN");
            address.setLongitude("k8DMNXDholhFcXKbvUW7LFWUoH4A20KMjxgRq2LtR6KgJdFlCh");
            address.setStateId((java.lang.String) StateTest._getPrimarykey());
            address.setZipcode("C6Q6yl");
            address.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            address.setEntityValidator(entityValidator);
            address.isValid();
            addressRepository.save(address);
            map.put("AddressPrimaryKey", address._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            Address address = addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
            address.setAddress1("pT62L9uXPougWiqqmD5SlNAgNEyQZAt9u4JaxbocaN4GQoQtlW");
            address.setAddress2("9C2rrnnUXxYHClXwDNfWQWifhGLkvoQdATcwPe75FReEz13p1r");
            address.setAddress3("3kZiXKQOxnGDs2wy1S62Y4QSgqDBwL73OOjGo9FZZSnjV1xJBs");
            address.setAddressLabel("aXWfu3uEpQ8");
            address.setLatitude("y0cTSuiOAvzgoOClEq6gdxbzrB0j8KuRZBkEyhmRehGiyFI9gp");
            address.setLongitude("NNsUv9A4cIdLm4cRfidCL57NIgDwUdRxU1uHUfe5qlpqXUa2uO");
            address.setVersionId(1);
            address.setZipcode("FzqB7i");
            address.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            addressRepository.update(address);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByaddressTypeId() {
        try {
            java.util.List<Address> listofaddressTypeId = addressRepository.findByAddressTypeId((java.lang.String) map.get("AddressTypePrimaryKey"));
            if (listofaddressTypeId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycityId() {
        try {
            java.util.List<Address> listofcityId = addressRepository.findByCityId((java.lang.String) map.get("CityPrimaryKey"));
            if (listofcityId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<Address> listofcountryId = addressRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
            if (listofcountryId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBystateId() {
        try {
            java.util.List<Address> listofstateId = addressRepository.findByStateId((java.lang.String) map.get("StatePrimaryKey"));
            if (listofstateId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            addressRepository.delete((java.lang.String) map.get("AddressPrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
