<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
  <style>
  body {
      position: relative;
  }

   .image
  {
    width:100vw;
    display:flex;
    align-items:center;
  }
  </style>
</head>
<body data-spy="scroll" data-target=".navbar" data-offset="50">

<nav class="navbar navbar-expand-sm bg-dark navbar-dark fixed-top">
  <ul class="navbar-nav">
    <li class="nav-item">
      <a class="nav-link" href="#section1">Introduction </a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="#section2">Feasibility Study</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="#section3">Requirement Analysis</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="#section4">Software Requirement Specification (SRS)</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="#section5">Testing</a>
    </li>

    <li class="nav-item">
      <a class="nav-link" href="#section6">ER Diagrams</a>
    </li>
    <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
        DFDs
      </a>
      <div class="dropdown-menu">
        <a class="dropdown-item" href="#section71">Level 0</a>
        <a class="dropdown-item" href="#section72">Level 1</a>
        <a class="dropdown-item" href="#section73">Level 2</a>
      </div>
    </li>
  </ul>
</nav>

<div id="section1" class="container-fluid bg-light" style="padding-top:70px;padding-bottom:70px">
<p>  <h4>TITLE OF PROJECT:</h4>   BookShelf </p>

  <p>
  <h4>INTRODUCTION</h4>
  BookShelf is a online orders and stock Register. A Stock Register is a software program that helps the user(s) or businessmen or accountants to keep record of various items that are currently present in stock. Moreover, a stock register also facilitates a user by allowing him/her keeping a record of various purchases made and sales generated on daily basis. Thus, sales and purchase modules work independently but must work in synchronization to provide consistent data.
  Most of the today’s businessmen especially small and middle class still depend upon the traditional paper based methods to keep track of their sales, purchase and manage their stocks accordingly. Although this traditional method is still considered reliable but it has many shortcomings too. Traditional paper based technology is a time consuming method and requires a lot of labour. Moreover, it is vulnerable to human errors which in case of business might prove to be fatal. Inconsistency in data is also quite frequently observed. Backup procedures are also less implemented in traditional systems majorly because of increase in labour cost and time required to implement this.
  The proposed system eliminates all the above problems hence it has become highly popular among various professionals and is also recommended by various businessmen for smooth management of their stocks.
  <p>

  <h4>OBJECTIVES</h4>
  <p>The primary objective of a Stock Register is “ease of maintenance of stocks /records”. An acceptable stock register must also fulfil other objectives which are described below:
<ol type="1">
  <li> Facilitate ease of maintenance of stocks.  </li>
  <li> Reduce cost of maintenance of records.</li>
  <li> Reduce overall time involved in record maintenance.</li>
  <li> Ensure Data Consistency and Integrity.</li>
  <li> Conduct Authorisation of accessing party.</li>
  <li> Provide interactive view or user friendly view to the user.</li>
  <li> Have an abstract mechanism which automatically updates stocks on sales/purchase entries.</li>
  <li>8. Provide mechanism by which user can delete the unwanted entries.</li>
  <li> Provide mechanism by which user can alter the records entered without data being getting inconsistent.</li>
  <li> Provide Mechanism by which user can view the records (sales or purchase).</li>
</ol>
  </p>
<h4>  Pros and Cons </h4>
  <p><h5>Pros:</h5>
    <ol type="1">
  <li> Maintenance of stocks becomes easier.</li>
  <li> This System also reduces cost of maintenance.</li>
  <li> This System also involves less use of labour.</li>
  <li> Integrity of data is ensured by use of appropriate DBMS.</li>
  <li> Backup procedures of stocks becomes very easy and less time consuming as compared to traditional paper based stock management system.</li>
  <li> Only trusted users are allowed to access the data. Therefore, data security is ensured by stock register.</li>
  <li> One of the advantages of using inbuilt Stock Register is that user does not need to have any knowledge or experience of stock handling. He or She only needs to enter the data and record maintenance will be done automatically by the application.</li>
  <li> If records get damaged appropriate recovery procedure can be applied to ensure that data is gained back.</li>
  <li> Stock Register gives real time access to data.</li>
  <li> Stock Register also provides user with other useful features which makes stock maintenance easier and facilitates business functions.</li>
</ol>
  </p>

<p>
  <h5>Cons:</h5>
    <ol type="1">
  <li> Stock Register application requires knowledge of computer applications.</li>
  <li> To recover the data technical support is required.</li>
  <li> Crash of computer system may lead to loss of entire data.</li>
  <li> It might become difficult initially for a user to understand the system.</li>
  <li> Careful inspection of the system is required before fully functionally implementing it.</li>
  <li> Frequent Maintenance of the proposed system is required.</li>
  <li> Stock Register application is quite expensive as compared to traditional systems.</li>
  <li> Most of the business organisations have different requirements than the others, therefore, Stock Register need to be customised independently for each of them which makes it tedious and time consuming task for the developers.</li>
</div>

<div id="section2" class="container-fluid bg-light" style="padding-top:70px;padding-bottom:70px">
  <center><h4><u>FEASABILITY STUDY</u></h4></center>
<p>

<p>
A good Feasibility Study helps to objectively decide whether to proceed with a proposed project. A Feasibility Study should have broad considerations when considering whether to undertake a new project. It should consider things such as technological limitations, the marketplace, your marketing strategy, staffing requirements, schedule and financial projections.
</p>
<ol type="1">

<h5><li>  Executive Summary </li></h5>
<p>
  The executive summary provides an overview of the content contained in the feasibility study document. In this report a short description of the software product is provided to the reader for his/her enlightenment of the product. Various technological considerations have been taken and study is conducted upon them. Based upon the study best software tools are listed for the development of the product. The Marketplace of the product is discussed in the same report. Additionally, the various market strategies for the appropriate audiences have also been listed. Staff and organising requirements have been discussed in staff and organising section. Moreover, Schedule and Financial feasibility have also been conducted and results are concluded in last two sections.
</p>

<h5><li> Description of Product </li></h5>
<p>
BookShelf is a software program that aims at helping the user(s) or businessmen or accountants to keep record of various items that are currently present in stock. Moreover, a stock register also facilitates a user by allowing him/her keeping a record of various purchases made and sales generated on daily basis. Thus, sales and purchase modules work independently but must work in synchronization to provide consistent data. Main objective of BookShelf software is to streamline and accurate the process of managing various items in stock and get online orders. The product is aimed at managing the stocks in the inventory of an average businessman.
</p>

<h5><li> Technology Considerations</li></h5>
<p>
BookShelf  is a software program thus it requires appropriate software development tools. Moreover, the developed software must run on server machines independent of the operating system installed and hardware configuration in use.
Various software development tools that can be used are:
<ul>
<li>Eclipse IDE</li>
<li>My SQL</li>
<li>JDK 1.8.0_161</li>
<li>JRE 1.8.0_161</li>
<li>Spring MVC</li>
<li>Spring Security</li>
<li>HTML</li>
<li>Jquery</li>
<li>CSS</li>
<li>BootStrap</li>
</ul>
</p>
<h5><li> Product Marketplace</li></h5>
<p>
This part of the feasibility study describes the existing marketplace for the products and/or services the organization is considering. BookShelf is website and hence can be used by anyone equipped with computer system. Hence, Marketplace has no fixed boundary i.e. it may be used in various countries.
</p>
<h5><li> Marketing Strategy</li></h5>
<p>
Marketing Strategy involves the process of deciding of how the organization will market its product or service. Online advertisements have been a very popular means for advertising software products. Advertisements may be done on online platforms or social media sites such as facebook ,YouTube, Instagram. Websites may also be used as a platform to advertise. Moreover, free sample may be distributed to potential customers so that they may get familiar with the product and give us feedback and may even further refer the product.
</p>

<h5><li> Organisation and Staffing</li></h5>
<p>
Additional staffing in order to maintain the product quality and increasing user demands may be required. To maintain the product a time to time input from software developers will be required to remove various problems that might still prevail in the software program. Moreover, a customer support staff may be required to help the users to troubleshoot any problems that might happen occasionally.
</p>

<h5><li> Schedule</li></h5>
<p>
This section of the feasibility study is intended to provide a high level framework for implementation of the product or service being considered. This section is not intended to include a detailed schedule as this would be developed during project planning should this initiative be approved. This section may include some targeted milestones and timeframes for completion as a guideline only.
The  BookShelf website is intended to be completed within the time frame of 15 days .
</p>
<h5><li> Financial Projections</li></h5>
<p>
The financial projections for the feasibility study provide a description of the financial projections the new initiative is expected to yield versus additional costs. Financial projections are one key aspect of new project selection criteria. The  BookShelf software program requires no investment on software programs because all the mentioned software tools mentioned in feasibility report are open source softwares.
</p>
<p>

</div>

<div id="section3" class="container-fluid bg-light" style="padding-top:70px;padding-bottom:70px">
<h4><u><center>  Requirement Analysis </center></u></h4>

<p>
 BookShelf is a software program that helps the user(s) or businessmen or accountants to keep record of various items that are currently present in stock. Moreover, a stock register also facilitates a user by allowing him/her keeping a record of various purchases made and sales generated on daily basis. Thus, sales and purchase modules work independently but must work in synchronization to provide consistent data.
A computerised stock register eliminates all problems present in traditional stock management techniques hence it has become highly popular among various professionals and is also recommended by various businessmen for smooth management of their stocks.
</p>

<h6>Existing System</h6>
<p>
Most of the today’s businessmen especially small and middle class still depend upon the traditional paper based methods to keep track of their sales, purchase and manage their stocks accordingly. Although this traditional method is still considered reliable but it has many shortcomings too. Traditional paper based technology is a time consuming method and requires a lot of labour. Moreover, it is vulnerable to human errors which in case of business might prove to be fatal. Inconsistency in data is also quite frequently observed. Backup procedures are also less implemented in traditional systems majorly because of increase in labour cost and time required to implement this.  Moreover, they cannot reach a wider audience.
<p>

<h6>
Proposed System
</h6>

<p>
BookShelf is a software program that aims at helping the user(s) or businessmen or accountants to keep record of various items that are currently present in stock. Moreover, a stock register also facilitates a user by allowing him/her keeping a record of various purchases made and sales generated on daily basis. Thus, sales and purchase modules work independently but must work in synchronization to provide consistent data. Main objective of BookShelf  is to streamline and accurate the process of managing various items  in stock and online orders. The product is aimed at managing the stocks in the inventory of an average businessman.Moreover, they can reach a wider audience.
</p>

<h6>Modules</h6>
<ol type="1">
<li>Login Page</li>
<li>Sign Up</li>
<li>Admin page (View books , orders and purchases)</li>
<li>Make an order</li>
<li>Add a books purchase</li>
</ol>

<h6>Login Page</h6>
<p>
This page authenticates the user by use of username and password. The password is stored in database.
<p>
<h6>Admin Page</h6>
<p>
Admin can view all books in stocks , orders and purchases he/she made.
</p>
<h6>Orders</h6>
<p>To make orders by users.</p>
<h6>Add a purchase</h6>
<p>
This module enables the admin to add new books.
</p>
</div>

<div id="section4" class="container-fluid bg-light" style="padding-top:70px;padding-bottom:70px">
<h5><u><center>  Software Requirements Specification (SRS)</center></u></h5>

  <ol type="1">
  <li><h6><u> INTRODUCTION </u><h6></li>

  <ol type="a">
  <strong><li> PURPOSE</li> </strong>
    <p>
  BookShelf is a online orders and stock Register. A Stock Register is a software program that helps the user(s) or businessmen or accountants to keep record of various items that are currently present in stock. Moreover, a stock register also facilitates a user by allowing him/her keeping a record of various purchases made and sales generated on daily basis. Thus, sales and purchase modules work independently but must work in synchronization to provide consistent data.
  </p>

<strong><li>  OVERVIEW </li> </strong>
  <p>
  The final software products may contain the following modules each of them working independently:
  <ul>
    <li>Login Page</li>
    <li>Sign Up</li>
    <li>Admin page (View books , orders and purchases)</li>
    <li>Make an order</li>
    <li>Add a books purchase</li>
  </ul>
</p>
<strong><li>  Goals of Implementation </li> </strong>
  <p>
  Following are the goals of implementation for the desired software product :
  <ol type="1">
  <li> Maintenance of stocks should become easier.</li>
  <li> Stock Register should reduce cost of maintenance.</li>
  <li> Stock Register also should involve less use of labour.</li>
  <li> Integrity of data must be ensured by use of appropriate DBMS.</li>
  <li> Backup procedures of stocks must become easy and less time consuming as compared to traditional paper based stock management system.</li>
  <li> Only trusted users must be allowed to access the data. Therefore, data security must be ensured by stock register.</li>
  <li> One of the advantages of using a Stock Register is that user does not need to have any knowledge or experience of stock handling. He or She only needs to enter the data and record maintenance will be done automatically by the application.</li>
  <li> If records get damaged appropriate recovery procedure can be applied to ensure that data is gained back.</li>
  <li> Stock Register should be able to give real time access to data.</li>
  <li> Stock Register also provides user with other useful features which makes stock maintenance easier and facilitates business functions.</li>
  </ol>
  </p>

  <strong><li> FUNCTIONAL REQUIREMENTS </li> </strong>
  <p>

  This Section of document discuss functionalities required by user from the propose system. These are as follows:

  <h6>Login Page</h6>
  This page authenticates the user by use of username and password. The password is stored in database.
  <h6>Admin Page</h6>
  Admin can view all books in stocks , orders and purchases he/she made.
  <h6>Orders</h6>
  To make orders by users.
  <h6>Add a purchase</h6>
  This module enables the admin to add new books.
  </p>


  <strong><li> Non-Functional Requirements  </li> </strong>
<p>
  <ol type="1">
  <li> Scalability</li>
  <li> Reliablity</li>
  <li> Maintainability</li>
  <li> Speed of use</li>
  <li> Ease of use</li>
  </ol>
</p>
  </ol>

</div>

<div id="section5" class="container-fluid bg-light" style="padding-top:70px;padding-bottom:70px">
  <center><h4><u>TESTING</u></h4></center>

    <ol type="1">
  <h6><li>Introduction:</li></h6>
  <p>
  Testing is the process of running a system with the intention of finding errors. Testing enhances the integrity of a system by detecting deviations in design and errors in the system. Testing aims at detecting error-prone areas. This helps in the prevention of errors in a system. Testing also adds value to the product by confirming to the user requirements.
  The main purpose of testing is to detect errors and error-prone areas in a system. Testing must be thorough and well-planned. A partially tested system is as bad as an untested system. And the price of an untested and under-tested system is high.
  The implementation is the final and important phase. It involves user-training, system testing in order to ensure successful running of the proposed system. The user tests the system and changes are made according to their needs. The testing involves the testing of the developed system using various kinds of data. While testing, errors are noted and correctness is the mode.
  </p>
  <h6><li>Objectives of Testing</li></h6>
  <p>
  Testing is a process of executing a program with the intent of finding errors. A Successful test case is one that uncovers an as- yet-undiscovered error
  System testing is a stage of implementation, which is aimed at ensuring that the system works accurately and efficiently as per the user need, before the live operation commences. As stated before, testing is vital to the success of a system. System testing makes a logical assumption that if all parts of the as system are correct, the goal will be successfully achieved. A series of tests are performed before the system   is ready often the user acceptance test.
  </p>
  <h6><li>Testing Methods</li></h6>
  <p>
  System testing is the stage of implementation. This is to check whether the system works accurately and efficiently before live operation commences. Testing is vital to the success of the system. The candidate system is subject to a variety of tests: on line response, volume, stress, recovery, security and usability tests. A series of tests are performed for the proposed system is ready for user acceptance testing.
  <br><br><strong>The Testing Steps are:</strong><br>
  <p>
  <ul>
  <li><u>UNIT TESTING:</u>
  Unit testing focuses efforts on the smallest unit of software design. This is known as module testing. The modules are tested separately. The test is carried out during programming stage itself. In this step, each module is found to be working satisfactory as regards to the expected output from the module
  </li>
  <li><u>INTEGRATION TESTING</u>: Data can be lost across an interface. One module can have an adverse effect on another, sub functions, when combined, may not be linked in desired manner in major functions. Integration testing is a systematic approach for constructing the program structure, while at the same time conducting test to uncover errors associated within the interface. The objective is to take unit tested modules and builds program structure. All the modules are combined and tested as a whole.</li>
  <li><u>VALIDATION:</u> At the culmination of the integration testing, Software is completely assembled as a package. Interfacing errors have been uncovered and corrected and a final series of software test begin in validation testing. Validation testing can be defined in many ways, but a simple definition is that the validation succeeds when the software functions in a manner that is expected by the customer. After validation test has been conducted, one of the three possible conditions exists.</li>
  <li><u>OUTPUT TESTING:</u> After performing the validation testing, the next step is output testing of the proposed system, since no system could be useful if it does not produce the required output in a specific format. The output format on the screen is found to be correct, The format was designed in the system design time according to the user needs. For the hard copy also; the output comes as per the specified requirements by the user. Hence output testing did not result in any correction for the system.</li>
  <li><u>USER ACCEPTANCE TESTING:</u> User acceptance of a system is the key factor for the success of any system. The system under consideration is tested for the user acceptance by constantly keeping in touch with the prospective system users at the time of developing and making changes whenever required.
    </li>
  </ul>
  </p>
  </p>
</ol>
</div>

<div id="section6" class="container-fluid bg-light" style="padding-top:70px;padding-bottom:70px">
  <h4><center><u>ER Diagrams</u> </center></h4>
  <div class="image">
    <img class="img-fluid image" src="resources/images/ERD.png">
</div>
</div>

<div id="section71" class="container-fluid bg-light" style="padding-top:70px;padding-bottom:70px">
  <h4><center><u>DFD Level 0</u> </center></h4>
  <div class="image">
    <img class="img-fluid image" src="resources/images/Level 0.jpeg">
</div>
</div>

<div id="section72" class="container-fluid bg-light" style="padding-top:70px;padding-bottom:70px">
  <h4><center><u>DFD Level 1</u> </center></h4>
  <div class="image">
    <img class="img-fluid image" src="resources/images/Level 1.jpeg">
</div>
</div>

<div id="section73" class="container-fluid bg-light" style="padding-top:70px;padding-bottom:70px">
  <h4><center><u>DFD Level 2</u> </center></h4>
  <div class="image">
    <img class="img-fluid image" src="resources/images/Level 3.jpeg">
</div>
</div>

</body>
</html>
