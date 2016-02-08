package com.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.CoreContactsRepository;
import com.app.shared.contacts.CoreContacts;
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
import com.app.shared.contacts.Gender;
import com.app.server.repository.GenderRepository;
import com.app.shared.location.Language;
import com.app.server.repository.LanguageRepository;
import com.app.shared.location.Timezone;
import com.app.server.repository.TimezoneRepository;
import com.app.shared.contacts.Title;
import com.app.server.repository.TitleRepository;
import com.app.shared.contacts.CommunicationData;
import com.app.shared.contacts.CommunicationGroup;
import com.app.server.repository.CommunicationGroupRepository;
import com.app.shared.contacts.CommunicationType;
import com.app.server.repository.CommunicationTypeRepository;
import com.app.shared.location.Address;
import com.app.server.repository.AddressRepository;
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
public class CoreContactsTestCase {

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

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
            Gender gender = new Gender();
            gender.setGender("93vjxcWlpgAbXKT5i6f2T3LuBX8xd1m21rWBRWnXaCZEx5dKrC");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("e6");
            language.setAlpha3("LRv");
            language.setAlpha4("AUK8");
            language.setAlpha4parentid(11);
            language.setLanguage("4BJ2ZUPDCaMef9132kQPrXKFiyWqjR2ERWAp1fBEwNpT9fC9bW");
            language.setLanguageDescription("6rm1nQczfR8YmRFRsstc87PhZK17BCIkP4hijhnlwLagzTuNbd");
            language.setLanguageIcon("eTyn9L7JPP6xUKLG5x0vHgMe7otIQ7enox1M0JW9sMCDTY8KzH");
            language.setLanguageType("jjqnToko5njpJeQem3KagTvA9shiRTnJ");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("3NeTiETrmQwgXDCXokhjvKM0rvvcnXK6qTYYvaxyJf0VlCLYhW");
            timezone.setCountry("Q7tNXrwKDe35WpZSRkk6K4Q3CYeoN3qxM8drb4LBJoP81m9TEb");
            timezone.setGmtLabel("Q5W7NSLheQhb7yvi8QSPS9KPKbcdmUB5VOm6d2fvx3iPFBqcOS");
            timezone.setTimeZoneLabel("b4SyvUlhJrGI2qTRYq2nNZJcuVK973EkqSbPZLOZESSHZjzVKv");
            timezone.setUtcdifference(0);
            Title title = new Title();
            title.setTitles("y2agkqZP8ebobizhlkMwqetmsyh6M4Gp3EBuMP837hdJZuuzjt");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setAge(109);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("KFoMZwkI4vaUFwtSA8EyNDrh1GIETNgghhqtqbURvAYMtnXNQp");
            corecontacts.setFirstName("H7JFItczzISROWQcfNEHbnR5Ih98o99Mb4FZa76OQUwfwEQawx");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("j9nLPvJrcD2BmWGhiWA7HVV73RxyCrylqvlZVy9N0pYl5vszrh");
            corecontacts.setMiddleName("fIRfANiRvwi2bG79SU78JwaWVdokuAfjEMRRvs0MlBOxFjYR00");
            corecontacts.setNativeFirstName("jQ7Bo3pJwfSa1B7Go1bmvtH2XJA6agcc4Gu8eDnmKacr5azcjU");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("qrlcdkm8fQjBagNpDwomeb8Gz2PfAxouVVMpNMQb9gnhC9D0q3");
            corecontacts.setNativeMiddleName("OMFTZLDMB4IX930CV4ZdaC6ls1HdL80DCjobjy8XZtCRguHy1g");
            corecontacts.setNativeTitle("Wyn4gxtXNmUmcTd3y3uAeRtK6dkS9mwVA1MRXHy1fpXTy1nu1B");
            corecontacts.setPhoneNumber("AiSkQ0zMWV2Uaayptixm");
            corecontacts.setTimezone(timezoneRepository.save(timezone));
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
            CommunicationData communicationdata = new CommunicationData();
            communicationdata.setCommData("9");
            CommunicationGroup communicationgroup = new CommunicationGroup();
            communicationgroup.setCommGroupDescription("UPzA73KaNXqrWHBtDGscJUGWv2XvTzwOorsrN3VGJsBaxglabP");
            communicationgroup.setCommGroupName("1zpAJTAOvWDEDvnLoR0eFWaoP1KJIy86WCLZOhI1k8Qj4RiIzk");
            CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
            CommunicationType communicationtype = new CommunicationType();
            communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationtype.setCommTypeDescription("3gtVMrjzq8SbzuDx4rYQ0ZQJmMFuv3FFsd7ospMx9UisijZvms");
            communicationtype.setCommTypeName("eQdYpKvSLpvpdujxG1lBd9jLlVRhiTXUtxbLhp7hWPjiWTMkSi");
            CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
            communicationdata.setCommData("3");
            communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            listOfCommunicationData.add(communicationdata);
            corecontacts.addAllCommunicationData(listOfCommunicationData);
            java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
            Address address = new Address();
            address.setAddress1("u9RnD2NWdPBTsrm6LtYszxfgKbaPjO5oYF4T53FvHazTLV1F2n");
            address.setAddress2("POh2tVNQYzVT1irsTLNE5mSFKvCIH5hzmyjcaYAGY9vjCmQDg3");
            address.setAddress3("eBrVSfaqPHjW2Uh0o1pFbdNlO7rWoAxjkqDBGB2RtKETg7y2G5");
            address.setAddressLabel("6KniH785K5f");
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("grjfu1iFmDRFcN4QddN97jzKpjsGFWlpwLnzqTT3BZB3pzR6Tp");
            addresstype.setAddressTypeDesc("f3ESz6i3DTzp0R5WmSVlXzlGAOJKF6HELo3V6wH322Nm836PAf");
            addresstype.setAddressTypeIcon("eD582RdFmC4hrZfCSofY6CGJ2j7vl523W2QyFESuaN7RtnFqVW");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(1);
            city.setCityCodeChar2("iA5WrYcSu2soxIewlILNBlHhxO3w2YyU");
            city.setCityDescription("YdFDxPgmgN8CV51C0lOMYKDGi9m7QsUIgKkQdy8S7ZKgM3B0UO");
            city.setCityFlag("ZEQVJKAamDlCgVia4gzRyzMLk18ujNeoeQbZfu2qrTFQ6RbddV");
            city.setCityLatitude(3);
            city.setCityLongitude(2);
            city.setCityName("5E3Qwm9jt2kgeQiwJ3sCM7npNAQO6CPz4EnJQx0sA5ld37vXfd");
            Country country = new Country();
            country.setCapital("RJaUO7MZ0pKX0xWABtFLUsCXt2yxcuxa");
            country.setCapitalLatitude(11);
            country.setCapitalLongitude(4);
            country.setCountryCode1("CTD");
            country.setCountryCode2("X5A");
            country.setCountryFlag("kx9GM7Ux70I4ID4U0TcwvV2xGl41lmVz0RuGNA0EMj8uawIE5X");
            country.setCountryName("wNGEVQShTD2ZAO9Car91g1bLleoUH8HHkXZWsuDZjnfcYrHY3V");
            country.setCurrencyCode("DzG");
            country.setCurrencyName("YS7x7DURHctGKvYS7jtAL339Bv9LQsMyJhdel7hE0JFM4Ogqr0");
            country.setCurrencySymbol("D3AvnoNhmTuq0GrrhFZZ1W4GCnJKnFn5");
            country.setIsoNumeric(10);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("4s8h0T2qfPhvl34U7LAYrgtHlbt3cxECElAQxKnYlbt5jYstZF");
            state.setStateCapitalLatitude(2);
            state.setStateCapitalLongitude(6);
            state.setStateCode(0);
            state.setStateCodeChar2("SW7GsK6AuDFT1dWvUQVkNdmR4xGXFkfP");
            state.setStateCodeChar3("xa7ghBlj5XbSjYHEgPWEhuWK4MpZqtnY");
            state.setStateDescription("SodDqzYisLwe2daEVte9TjgYlKTE5FlBAEP64aq1OMLO4nitFL");
            state.setStateFlag("2itIXBYXKdQsP6b0FyvSOQVJJPUIcoLzFh8JzE3danM619dSIQ");
            state.setStateName("VVM4yvPjzEbNzPW8NAy5FRfDmjJGKlnk1VGe7byHqVwCLc349b");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(0);
            city.setCityCodeChar2("z5sUMNZM1BVkzByw1ovj5ogxPREG2Vbk");
            city.setCityDescription("iiQNGRPMB5Fsjj34vJTjNwo7pw5y6624mhnPZLwiVHBuFAYrrr");
            city.setCityFlag("AVapYsXEJf7148nV0vsWsFodnS5S51bnHqX9CMQwv8b6tOLsSM");
            city.setCityLatitude(6);
            city.setCityLongitude(10);
            city.setCityName("x0dhWxczXHSHuCxIbseIlDhVDCTdF0LzyyEzYZrezY5d8i58rY");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            address.setAddress1("fvMLVF5b2sK6sVzI9Hh0wkdHtjKBuOaezJw2uyMNeqRoR40wov");
            address.setAddress2("nSwRg20itlC0iaYpzlacwbyEnCmurDswnaSVCB0tcQUtxtMswc");
            address.setAddress3("fYTeeUlCH2W304qKhHSQVVWYyTNCQqoScfaItER49jtjJFlYjD");
            address.setAddressLabel("X5JsfRRJzmU");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("pQzgjcVXqx95NsgN1BrNYSjxsWl3OGsrE2n4QUuYiRe7SjN8cB");
            address.setLongitude("xsrMh2J9Mw2fjOmDEXr38qRVqqWVraJK1LT2Oj0sopK6BvhDRg");
            address.setStateId((java.lang.String) StateTest._getPrimarykey());
            address.setZipcode("00S8Sj");
            listOfAddress.add(address);
            corecontacts.addAllAddress(listOfAddress);
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            corecontacts.setEntityValidator(entityValidator);
            corecontacts.isValid();
            corecontactsRepository.save(corecontacts);
            map.put("CoreContactsPrimaryKey", corecontacts._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private TitleRepository<Title> titleRepository;

    @Autowired
    private CommunicationGroupRepository<CommunicationGroup> communicationgroupRepository;

    @Autowired
    private CommunicationTypeRepository<CommunicationType> communicationtypeRepository;

    @Autowired
    private AddressRepository<Address> addressRepository;

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
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            CoreContacts corecontacts = corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
            corecontacts.setAge(104);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("nBGKKi6kAaZNSyWpKyGhB1bDAxMcjcn7wVg0qxssPIh907aEBU");
            corecontacts.setFirstName("cVHJlFJVkiOuAvt838831ZCrsBQKDv38Ijo5PjMzUrp5HFWdoH");
            corecontacts.setLastName("whH4Tw5YMbMa0QYRMI8rv31PJyqe1FPQ80NFDNeAnv4MOIsWS8");
            corecontacts.setMiddleName("1ozqY1A3HOm7xdBWoQpopSU6QOQALJ1BHaxs3wfLevXO0pJDep");
            corecontacts.setNativeFirstName("zq13KazsV5qkXrjjr9iOAY20KRsx3uvOERhoCvnoICtb4dAq7t");
            corecontacts.setNativeLastName("QEan2qViGBjwSIzSZBoTxCYB6W9F6hV8oVkKvyuqXM3rPbeFY1");
            corecontacts.setNativeMiddleName("qa3OjCGWK2TLcpI9ZOsQbQ2lcWs5et2bBplJNICfpI3kaKarH8");
            corecontacts.setNativeTitle("mBGqBwqZMpnDw1T8O58D7QdFYSN8Zqim78x4gkVjM1o73qgh1p");
            corecontacts.setPhoneNumber("hslXqYQtGa6szYcLNBTk");
            corecontacts.setVersionId(1);
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            corecontactsRepository.update(corecontacts);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBygenderId() {
        try {
            java.util.List<CoreContacts> listofgenderId = corecontactsRepository.findByGenderId((java.lang.String) map.get("GenderPrimaryKey"));
            if (listofgenderId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBynativeLanguageCode() {
        try {
            java.util.List<CoreContacts> listofnativeLanguageCode = corecontactsRepository.findByNativeLanguageCode((java.lang.String) map.get("LanguagePrimaryKey"));
            if (listofnativeLanguageCode.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBytitleId() {
        try {
            java.util.List<CoreContacts> listoftitleId = corecontactsRepository.findByTitleId((java.lang.String) map.get("TitlePrimaryKey"));
            if (listoftitleId.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.delete((java.lang.String) map.get("CoreContactsPrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            communicationtypeRepository.delete((java.lang.String) map.get("CommunicationTypePrimaryKey")); /* Deleting refrenced data */
            communicationgroupRepository.delete((java.lang.String) map.get("CommunicationGroupPrimaryKey")); /* Deleting refrenced data */
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey")); /* Deleting refrenced data */
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
