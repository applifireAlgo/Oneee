package com.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.LoginRepository;
import com.app.shared.authentication.Login;
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
import com.app.shared.contacts.CoreContacts;
import com.app.server.repository.CoreContactsRepository;
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
import com.app.shared.authentication.User;
import com.app.server.repository.UserRepository;
import com.app.shared.authentication.UserAccessDomain;
import com.app.server.repository.UserAccessDomainRepository;
import com.app.shared.authentication.UserAccessLevel;
import com.app.server.repository.UserAccessLevelRepository;
import com.app.shared.authentication.PassRecovery;
import com.app.shared.authentication.Question;
import com.app.server.repository.QuestionRepository;
import com.app.shared.authentication.UserData;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class LoginTestCase {

    @Autowired
    private LoginRepository<Login> loginRepository;

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
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setAge(21);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("I02srdCbbLRF061ySG5ANWdmopGtoFp3ITod72LutIxSNqgy7c");
            corecontacts.setFirstName("MHlmkbQXi7GUfvZrddte33ZCKzQUWolDPIB93alV1Xt9vp8ICu");
            Gender gender = new Gender();
            gender.setGender("GpJSoLfend7j2ArDZSWldPvsTDq6afxABXBZT7vOOxlklmOHc4");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("Un");
            language.setAlpha3("C2L");
            language.setAlpha4("WD4W");
            language.setAlpha4parentid(6);
            language.setLanguage("3VF2kFtFuITuWaLByrtDhj7FnN8W50l3GV9PzXBK5ps8bj0vc3");
            language.setLanguageDescription("viyVY86cMVEzXpKO5yMKE6StouopTqXt1vX9RepewjtYXu5KmR");
            language.setLanguageIcon("yVGSZeQkhJ2DS4rimM2ugjFDJIj1mndHKLB05R3hoqouo0hh5c");
            language.setLanguageType("vBbeWJyO4KCykBijvLe05QpnbNoO4YJ0");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("AvlrqpxfUgf3vNJloCifChYCxV6FHjgMg8UkXFzXEsQ4KXmtfM");
            timezone.setCountry("4VeJmrLPf9lLUujZtraoAZrENFjIzbnBk1JBemz1EI6IVQXpAl");
            timezone.setGmtLabel("rRsuWaXptDS1YLOeYWURcLHp1d7aLwX8fwRYFoZcUNWCaqf7H9");
            timezone.setTimeZoneLabel("QMnRrdUm8Z3ACnjGQjRj3ywFmc8QU2x3IrEsxS52KoTVt27jxC");
            timezone.setUtcdifference(5);
            Title title = new Title();
            title.setTitles("CGePcxOjCf57ZBrjhV0mAIWJgsroQGLnqtJXNTxqOqq4XcXlic");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            corecontacts.setAge(55);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("wJNmHMczZ3iCTwDMbGZtEVzULmAWiXxfTkDuhE895sEE1TIcec");
            corecontacts.setFirstName("BIGzFHjw7C5n1J6oSt6m8B5evUVySEfrSytdkz8S7xnf4EiGgF");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("OGopY2XhDiKteWGAxVGCc4Yl0gHblMXid4VC0jTvnK6Va3GrJX");
            corecontacts.setMiddleName("SpTjL2kCnkrlJKdu7QIEQrSjf7aNZc1eTsLVBYDaRMk4MCgfFm");
            corecontacts.setNativeFirstName("QZJ08UMOflLRxumj9ki7fhMO8RRzargSLUcDYLb3yvCbTCkr0Q");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("cqmxg4HxVNZlC7v0LHQgTp2YaduMbzLsG1vbglr0KhfLiaR77w");
            corecontacts.setNativeMiddleName("24OZ5Stg0q6HABF7ptyYFyQVM23ODjtlyu5IIhDN6vjhTrr09v");
            corecontacts.setNativeTitle("PfQOklazQoOZnyiUZUzNxG1pKFensqOJHraHujiwiBYO365kft");
            corecontacts.setPhoneNumber("QtXREzEVIeGmQLslosqi");
            timezone.setTimeZoneId(null);
            corecontacts.setTimezone(timezoneRepository.save(timezone));
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
            CommunicationData communicationdata = new CommunicationData();
            communicationdata.setCommData("e");
            CommunicationGroup communicationgroup = new CommunicationGroup();
            communicationgroup.setCommGroupDescription("QJi4xXHYHqgPCpZ6AQjoBMU1MAglGW4PWRHIB8tIy0CiCq5bVQ");
            communicationgroup.setCommGroupName("F72TRslySRnTEOVm6THNTPEBP6IkmXVR8n3yI46mlvVxkbldK9");
            CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
            CommunicationType communicationtype = new CommunicationType();
            communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationtype.setCommTypeDescription("WoENIUe44EW87UfVTKU7MHIA3Py6Thaptk4QIGrQVyWgvNwxNB");
            communicationtype.setCommTypeName("BqctTpBHDeqNwIwpyDVmfRrTxHufazWkC6olM45UTxlsNQ3459");
            CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
            communicationdata.setCommData("U");
            communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            listOfCommunicationData.add(communicationdata);
            corecontacts.addAllCommunicationData(listOfCommunicationData);
            java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
            Address address = new Address();
            address.setAddress1("AzY0wPVBxxRDUvPLHDf9XAMu2Gx7DgnrKYKvtw8oFCtPhCsoIQ");
            address.setAddress2("YFm1TaHbUepXxTwUwea6dxYIa2tCbFYOflFldxOq6TLUVt6NSr");
            address.setAddress3("WRcu6pCHQFEZhKtlrCCKXlsG4ofqcG6z9h8ug20PvCojfDUFYO");
            address.setAddressLabel("kthtsIP9axb");
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("H3VjfegFLnlvbSXHr3AF7Df5zBP5EDjxw6HDdl1XIoTCV3qLxb");
            addresstype.setAddressTypeDesc("w2rWALvLETW0iL1DgvsLcZkuFDSufCtiSAbWAAeTUe5VeApv74");
            addresstype.setAddressTypeIcon("9J4xhzo40qSKebA6Zx9N90Zawl6p0hYFlq501h8EwfigmxrmUl");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(3);
            city.setCityCodeChar2("V3wFz6wAW5VrNepfKmlQYL8N2CpuCO62");
            city.setCityDescription("hU8som0LA3Y9EJi8OR1322ZLwrVDC6sXeWQ9rnr9Jv3U1WZbSY");
            city.setCityFlag("lRoEV2qf2yTQ7RBUhLhp1ad1xofLqJsnXAsRuIdd37BiIfVNEa");
            city.setCityLatitude(6);
            city.setCityLongitude(9);
            city.setCityName("ptPWoyMLDCm2Mqv6ke0YhEKYkQlmmkHlXJ8QQW3YXj89S82gX8");
            Country country = new Country();
            country.setCapital("xqm5twiqoD81Xc7JGvprRiVUGEeolLwK");
            country.setCapitalLatitude(4);
            country.setCapitalLongitude(3);
            country.setCountryCode1("csb");
            country.setCountryCode2("vRN");
            country.setCountryFlag("8Jvh8srNa6Yps6j5zSlaZSUdCnUzbuCNg22zmRSkGSLiJW869r");
            country.setCountryName("nQnpznnwNkYnbFbQ1qxQeIQlsQpPxKhqN2ApD2VzafpuUtGQYs");
            country.setCurrencyCode("Q0d");
            country.setCurrencyName("1a7zx3bN4gC6BLZab2TEZZzO0rJ5EKw3ooJkB1G0JU70ZjuGLo");
            country.setCurrencySymbol("1EotaeJJrwa7z1ecKPiYnZCfPrFCxZzB");
            country.setIsoNumeric(10);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("8ioAMX5s7iMWKJkCktINPdvFvpAjYoydr8TQC7qcJUIoPTMCf7");
            state.setStateCapitalLatitude(6);
            state.setStateCapitalLongitude(11);
            state.setStateCode(1);
            state.setStateCodeChar2("TxXM5qXYMvb7fUZU9khiOkRe6vh0Y3Ww");
            state.setStateCodeChar3("jLpPa89VrlDcRjceEZTdWuGSeMkFfjZE");
            state.setStateDescription("odL9l6S0Ra1e2ywfIMaQlDY26UJXeux9oO3K4ufNwxAYhxjy84");
            state.setStateFlag("v1O4oCMoj6Gnur7daXAEqhqZA5lrxnsdjkUE2p4hOt2N4NJtDN");
            state.setStateName("hRVaXg1kpGAOZs3APGQyQsVVuw4ktpJbwGNy95uXZ7YZXvJm5E");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(1);
            city.setCityCodeChar2("qHatT8ZGh2plnQXVBroyFcZer3FUmMmb");
            city.setCityDescription("OfWPUCzAK2rpA5rvl7NMhvBnkQX1v8hvRKFrd4fIU2McyxI1yV");
            city.setCityFlag("6dkh7LHtECDMiW2DfasvFogRrnDx1z7n5FyNCxT65HyQfWip2w");
            city.setCityLatitude(3);
            city.setCityLongitude(3);
            city.setCityName("qx1VvWBY71lp2MNNkHBNlevTAYgyBIyh7QDJbTEQbzGCNN7aMr");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            address.setAddress1("rwjkmc48yM71l1k6oePqerf9CpIHT9bcfIh2Xm4Co0FIeU5byb");
            address.setAddress2("KpKmHjxOUWgYuUIwVuuhHQNGzAR0oE9LPkZQzkMK8ucwOvZ0l0");
            address.setAddress3("Id7rt24DKKBRLVs8xjhQAgDHqyioHbsenEYmsp4ROpOTLDNswX");
            address.setAddressLabel("iqDClaT986D");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("PReaa84bVXjttmZl0gQLlezv4us8vVBtiFMTx7BgtMscTWJl3k");
            address.setLongitude("xdBoGOMKRnorSFDZO4Irg5y3afPBTqV4rgbMQyeHY17PRKaKuw");
            address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setZipcode("RTqrDo");
            listOfAddress.add(address);
            corecontacts.addAllAddress(listOfAddress);
            User user = new User();
            user.setAllowMultipleLogin(1);
            user.setChangePasswordNextLogin(1);
            user.setGenTempOneTimePassword(0);
            user.setIsDeleted(0);
            user.setIsLocked(0);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(0);
            user.setPasswordAlgo("rf17VzmGoxX88Rybh3bzlnbtMLYuLyrEs516XqdaZsKYd2Qv3z");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(733);
            user.setUserAccessCode(0);
            UserAccessDomain useraccessdomain = new UserAccessDomain();
            useraccessdomain.setDomainDescription("EDdKO39TlNaKvkpmKOnviPxkUHyifO0C8iqIHGxXJyYXGtYkAk");
            useraccessdomain.setDomainHelp("LCYSy6IbW5KPDr2EJyJ2I6hXCBRyLJiR6t1ZwaXEksfgw1mZkl");
            useraccessdomain.setDomainIcon("WLW4Gc8JtAjJVQQJiegErlosOaTk9Gbtlh05jKbXhMPCJxDbtE");
            useraccessdomain.setDomainName("5s2e5ASCvs2hwJCiXyoxmMZ2zKpm1owYEZtZ8h81Ff1ElamGun");
            useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
            UserAccessDomain UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
            UserAccessLevel useraccesslevel = new UserAccessLevel();
            useraccesslevel.setLevelDescription("tlXm4RGWtOMATiplrQPSqhqk4uizKTReQVrlfJEAJLHQ2hsad0");
            useraccesslevel.setLevelHelp("dt2lRtuLN3qFwDeNqzwTyEApJUhYs2wbMbbSTKNT9VfkA84RVI");
            useraccesslevel.setLevelIcon("lQtM6UQ43HxNYHKJ6uxjUxQhDMuvsjwhfVwYm3Zk2rk6lzSB6m");
            useraccesslevel.setLevelName("mWZjTQ8TdtUgQmrDPn5U5yPBBLgN6QZnJQoPgF5yiazApppyJn");
            useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
            UserAccessLevel UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
            user.setAllowMultipleLogin(1);
            user.setChangePasswordNextLogin(1);
            user.setGenTempOneTimePassword(1);
            user.setIsDeleted(0);
            user.setIsLocked(0);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(1);
            user.setPasswordAlgo("R2CzaqAdyIxEmjUqn3gZgD95rGN8uXcXtSspincfWCTFUWcfC2");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(572);
            user.setUserAccessCode(2);
            user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
            user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<PassRecovery> listOfPassRecovery = new java.util.ArrayList<PassRecovery>();
            PassRecovery passrecovery = new PassRecovery();
            passrecovery.setAnswer("11oLfw52FLx81hdpKaU3NHJyVDvWU7p28Px7yQWzoZnZdVBTPi");
            Question question = new Question();
            question.setLevelid(5);
            question.setQuestion("KN3vJZSmsFXwltEAhC2Zji1InG3DzcgOeP9n1LJlRkEPeHZ7y8");
            question.setQuestionDetails("1");
            question.setQuestionIcon("dGmD8ky8kTwTmabG6mW7VRTyI3xDrzP5BcX0KCDKzyuOWZPhmM");
            Question QuestionTest = questionRepository.save(question);
            map.put("QuestionPrimaryKey", question._getPrimarykey());
            passrecovery.setAnswer("PBfSQVWoCseQsOUOgnTHrCgYGgY2cEybI7TaCvTnIDTUtxGIZ2");
            passrecovery.setQuestionId((java.lang.String) QuestionTest._getPrimarykey());
            passrecovery.setUser(user);
            listOfPassRecovery.add(passrecovery);
            user.addAllPassRecovery(listOfPassRecovery);
            UserData userdata = new UserData();
            userdata.setLast5Passwords("ySSiG5nMPWhVWblIBm9RcNsOPP60uXcZbbnqqyIvqSycerpz7o");
            userdata.setOneTimePassword("lTal7kjwfdXRBoKEdIPtR4mbCsKXwlDO");
            userdata.setOneTimePasswordExpiry(6);
            userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(123456789));
            userdata.setPassword("X8hNfZE10QPqDjYYgpnxCp2VWqCQaAZtJD2qlTZiRVzNLOKpAD");
            userdata.setLast5Passwords("JxkgELfI22wNi5laGpveejHLDjT6g2sQy4DDmQLlvX3SUFtmXV");
            userdata.setOneTimePassword("0vVMzm9gfJGPykfbV2o4zGeG87B5QcUT");
            userdata.setOneTimePasswordExpiry(0);
            userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(123456789));
            userdata.setPassword("gH7gml0ZCh6pXXKbIUEs3nI0HBUsSIaVMykvVbj0cZo1k1MPEH");
            userdata.setUser(user);
            user.setUserData(userdata);
            Login login = new Login();
            corecontacts.setContactId(null);
            login.setCoreContacts(corecontacts);
            login.setFailedLoginAttempts(5);
            login.setIsAuthenticated(true);
            login.setLoginId("utFSUmvH6i1p54nR0iqU8U8WjeSNdQajSxU4N84J76IUC06vII");
            login.setServerAuthImage("hCA0f3h7Y1O9RZgyji7c1851AZAgH1kx");
            login.setServerAuthText("bws2WPh7eMEZhpeo");
            user.setUserId(null);
            login.setUser(user);
            login.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            login.setEntityValidator(entityValidator);
            login.isValid();
            loginRepository.save(login);
            map.put("LoginPrimaryKey", login._getPrimarykey());
            map.put("CoreContactsPrimaryKey", login.getCoreContacts()._getPrimarykey());
            map.put("UserPrimaryKey", login.getUser()._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

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

    @Autowired
    private UserRepository<User> userRepository;

    @Autowired
    private UserAccessDomainRepository<UserAccessDomain> useraccessdomainRepository;

    @Autowired
    private UserAccessLevelRepository<UserAccessLevel> useraccesslevelRepository;

    @Autowired
    private QuestionRepository<Question> questionRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            Login login = loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
            login.setFailedLoginAttempts(4);
            login.setLoginId("JbQrEaHFlhlyjgQW6ANyzwoO1dNV6KyjSXmqmDUxuoppWtjrlL");
            login.setServerAuthImage("8eX7pe2MTl8tmBpRvNtIRlhF4sO3cUzF");
            login.setServerAuthText("TgHWCperFwFPevhl");
            login.setVersionId(1);
            login.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            loginRepository.update(login);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void testNQFindMappedUser() {
        try {
            loginRepository.FindMappedUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testNQFindUnMappedUser() {
        try {
            loginRepository.FindUnMappedUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            loginRepository.delete((java.lang.String) map.get("LoginPrimaryKey")); /* Deleting refrenced data */
            questionRepository.delete((java.lang.String) map.get("QuestionPrimaryKey")); /* Deleting refrenced data */
            useraccesslevelRepository.delete((java.lang.String) map.get("UserAccessLevelPrimaryKey")); /* Deleting refrenced data */
            useraccessdomainRepository.delete((java.lang.String) map.get("UserAccessDomainPrimaryKey")); /* Deleting refrenced data */
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
