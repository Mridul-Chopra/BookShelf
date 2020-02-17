<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
	<META HTTP-EQUIV="CONTENT-TYPE" CONTENT="text/html; charset=windows-1252">
	<TITLE></TITLE>
	<META NAME="GENERATOR" CONTENT="OpenOffice 4.1.5  (Win32)">
	<META NAME="AUTHOR" CONTENT="Mridul Chopra">
	<META NAME="CREATED" CONTENT="20200216;23103034">
	<META NAME="CHANGEDBY" CONTENT="Mridul Chopra">
	<META NAME="CHANGED" CONTENT="20200216;23252602">
</HEAD>
<BODY LANG="en-US" DIR="LTR">
<P ALIGN=CENTER STYLE="margin-bottom: 0.14in; line-height: 0.17in"><A HREF="requirementAnalysis.html">Back</A><META NAME="CHANGEDBY" CONTENT="Mridul Chopra">
    <A HREF="testing.html">Next</A></P>
<P ALIGN=CENTER STYLE="margin-bottom: 0.14in; line-height: 0.17in"><BR><BR>
</P>
<P ALIGN=CENTER STYLE="margin-bottom: 0.14in; line-height: 0.17in"><FONT COLOR="#00000a"><FONT FACE="Times New Roman, serif"><FONT SIZE=4 STYLE="font-size: 16pt"><U><B>Software
Requirements Specification (SRS)</B></U></FONT></FONT></FONT></P>
<P ALIGN=JUSTIFY STYLE="margin-bottom: 0.14in; line-height: 0.17in"><BR><BR>
</P>
<P ALIGN=JUSTIFY STYLE="margin-bottom: 0.14in; line-height: 0.17in"><FONT COLOR="#00000a"><FONT FACE="Times New Roman, serif"><FONT SIZE=4><B>1.
INTRODUCTION</B></FONT></FONT></FONT></P>
<P ALIGN=JUSTIFY STYLE="margin-bottom: 0.14in; line-height: 0.17in"><FONT COLOR="#00000a"><FONT FACE="Times New Roman, serif"><FONT SIZE=3><B>(a)
</B></FONT></FONT></FONT><FONT COLOR="#00000a"><FONT FACE="Times New Roman, serif"><FONT SIZE=3><U><B>PURPOSE</B></U></FONT></FONT></FONT></P>
<P ALIGN=JUSTIFY STYLE="margin-bottom: 0.14in; line-height: 0.17in"><FONT COLOR="#00000a"><FONT FACE="Times New Roman, serif"><FONT SIZE=3>BookShelf
is a online orders and stock Register. A Stock Register is a software
program that helps the user(s) or businessmen or accountants to keep
record of various items that are currently present in stock.
Moreover, a stock register also facilitates a user by allowing
him/her keeping a record of various purchases made and sales
generated on daily basis. Thus, sales and purchase modules work
independently but must work in synchronization to provide consistent
data.</FONT></FONT></FONT></P>
<P ALIGN=JUSTIFY STYLE="margin-bottom: 0.14in; line-height: 0.17in"><FONT COLOR="#00000a"><FONT FACE="Times New Roman, serif"><FONT SIZE=3><B>(b)
</B></FONT></FONT></FONT><FONT COLOR="#00000a"><FONT FACE="Times New Roman, serif"><FONT SIZE=3><U><B>OVERVIEW</B></U></FONT></FONT></FONT></P>
<P ALIGN=JUSTIFY STYLE="margin-bottom: 0.14in; line-height: 0.17in"><FONT COLOR="#00000a"><FONT FACE="Times New Roman, serif"><FONT SIZE=3>The
final software products may contain the following modules each of
them working independently:</FONT></FONT></FONT></P>
<UL>
	<LI><P ALIGN=JUSTIFY STYLE="margin-bottom: 0.14in; line-height: 0.17in">
	<FONT COLOR="#00000a"><FONT FACE="Times New Roman, serif"><FONT SIZE=3>Login
	Page</FONT></FONT></FONT></P>
	<LI><P ALIGN=JUSTIFY STYLE="margin-bottom: 0.14in; line-height: 0.17in">
	<FONT COLOR="#00000a"><FONT FACE="Times New Roman, serif"><FONT SIZE=3>Sign
	Up</FONT></FONT></FONT></P>
	<LI><P ALIGN=JUSTIFY STYLE="margin-bottom: 0.14in; line-height: 0.17in">
	<FONT COLOR="#00000a"><FONT FACE="Times New Roman, serif"><FONT SIZE=3>Admin
	page (View books , orders and purchases)</FONT></FONT></FONT></P>
	<LI><P ALIGN=JUSTIFY STYLE="margin-bottom: 0.14in; line-height: 0.17in">
	<FONT COLOR="#00000a"><FONT FACE="Times New Roman, serif"><FONT SIZE=3>Make
	an order</FONT></FONT></FONT></P>
	<LI><P ALIGN=JUSTIFY STYLE="margin-bottom: 0.14in; line-height: 0.17in">
	<FONT COLOR="#00000a"><FONT FACE="Times New Roman, serif"><FONT SIZE=3>Add
	a books purchase</FONT></FONT></FONT></P>
</UL>
<P ALIGN=JUSTIFY STYLE="margin-bottom: 0.14in; line-height: 0.17in"><FONT COLOR="#00000a"><FONT FACE="Times New Roman, serif"><FONT SIZE=4><U><B>2,
Goals of Implementation</B></U></FONT></FONT></FONT></P>
<P ALIGN=JUSTIFY STYLE="margin-bottom: 0.14in; line-height: 0.17in"><FONT COLOR="#00000a"><FONT FACE="Times New Roman, serif"><FONT SIZE=3>Following
are the goals of implementation for the desired software product :</FONT></FONT></FONT></P>
<P ALIGN=JUSTIFY STYLE="margin-bottom: 0.14in; line-height: 0.17in"><FONT COLOR="#00000a"><FONT FACE="Times New Roman, serif"><FONT SIZE=3>1.
Maintenance of stocks should become easier.</FONT></FONT></FONT></P>
<P ALIGN=JUSTIFY STYLE="margin-bottom: 0.14in; line-height: 0.17in"><FONT COLOR="#00000a"><FONT FACE="Times New Roman, serif"><FONT SIZE=3>2.
Stock Register should reduce cost of maintenance.</FONT></FONT></FONT></P>
<P ALIGN=JUSTIFY STYLE="margin-bottom: 0.14in; line-height: 0.17in"><FONT COLOR="#00000a"><FONT FACE="Times New Roman, serif"><FONT SIZE=3>3.
Stock Register also should involve less use of labour.</FONT></FONT></FONT></P>
<P ALIGN=JUSTIFY STYLE="margin-bottom: 0.14in; line-height: 0.17in"><FONT COLOR="#00000a"><FONT FACE="Times New Roman, serif"><FONT SIZE=3>4.
Integrity of data must be ensured by use of appropriate DBMS.</FONT></FONT></FONT></P>
<P ALIGN=JUSTIFY STYLE="margin-bottom: 0.14in; line-height: 0.17in"><FONT COLOR="#00000a"><FONT FACE="Times New Roman, serif"><FONT SIZE=3>5.
Backup procedures of stocks must become easy and less time consuming
as compared to traditional paper based stock management system.</FONT></FONT></FONT></P>
<P ALIGN=JUSTIFY STYLE="margin-bottom: 0.14in; line-height: 0.17in"><FONT COLOR="#00000a"><FONT FACE="Times New Roman, serif"><FONT SIZE=3>6.
Only trusted users must be allowed to access the data. Therefore,
data security must be ensured by stock register.</FONT></FONT></FONT></P>
<P ALIGN=JUSTIFY STYLE="margin-bottom: 0.14in; line-height: 0.17in"><FONT COLOR="#00000a"><FONT FACE="Times New Roman, serif"><FONT SIZE=3>7.
One of the advantages of using a Stock Register is that user does not
need to have any knowledge or experience of stock handling. He or She
only needs to enter the data and record maintenance will be done
automatically by the application.</FONT></FONT></FONT></P>
<P ALIGN=JUSTIFY STYLE="margin-bottom: 0.14in; line-height: 0.17in"><FONT COLOR="#00000a"><FONT FACE="Times New Roman, serif"><FONT SIZE=3>8.
If records get damaged appropriate recovery procedure can be applied
to ensure that data is gained back.</FONT></FONT></FONT></P>
<P ALIGN=JUSTIFY STYLE="margin-bottom: 0.14in; line-height: 0.17in"><FONT COLOR="#00000a"><FONT FACE="Times New Roman, serif"><FONT SIZE=3>9.
Stock Register should be able to give real time access to data.</FONT></FONT></FONT></P>
<P ALIGN=JUSTIFY STYLE="margin-bottom: 0.14in; line-height: 0.17in"><FONT COLOR="#00000a"><FONT FACE="Times New Roman, serif"><FONT SIZE=3>10.
Stock Register also provides user with other useful features which
makes stock maintenance easier and facilitates business functions.</FONT></FONT></FONT></P>
<P ALIGN=JUSTIFY STYLE="margin-bottom: 0.14in; line-height: 0.17in"><BR><BR>
</P>
<P ALIGN=JUSTIFY STYLE="margin-bottom: 0.14in; line-height: 0.17in"><FONT COLOR="#00000a"><FONT FACE="Times New Roman, serif"><FONT SIZE=4><U><B>3.
FUNCTIONAL REQUIREMENTS</B></U></FONT></FONT></FONT></P>
<P ALIGN=JUSTIFY STYLE="margin-bottom: 0.14in; line-height: 0.17in"><FONT COLOR="#00000a"><FONT FACE="Times New Roman, serif"><FONT SIZE=3>This
Section of document discuss functionalities required by user from the
propose system. These are as follows:</FONT></FONT></FONT></P>
<P ALIGN=JUSTIFY STYLE="margin-left: 0.5in; margin-bottom: 0.14in; line-height: 0.17in">
<BR><BR>
</P>
<P ALIGN=JUSTIFY STYLE="margin-bottom: 0.14in; line-height: 0.17in"><FONT COLOR="#00000a"><FONT FACE="Times New Roman, serif"><FONT SIZE=4><U><B>Login
Page</B></U></FONT></FONT></FONT></P>
<P ALIGN=JUSTIFY STYLE="margin-bottom: 0.14in; line-height: 0.17in"><FONT COLOR="#00000a"><FONT FACE="Times New Roman, serif"><FONT SIZE=4>This
page authenticates the user by use of username and password. The
password is stored in database.</FONT></FONT></FONT></P>
<P ALIGN=JUSTIFY STYLE="margin-bottom: 0.14in; line-height: 0.17in"><FONT COLOR="#00000a"><FONT FACE="Times New Roman, serif"><FONT SIZE=4><U><B>Admin
Page</B></U></FONT></FONT></FONT></P>
<P ALIGN=JUSTIFY STYLE="margin-bottom: 0.14in; line-height: 0.17in"><FONT COLOR="#00000a"><FONT FACE="Times New Roman, serif"><FONT SIZE=4>Admin
can view all books in stocks , orders and purchases he/she made.</FONT></FONT></FONT></P>
<P ALIGN=JUSTIFY STYLE="margin-bottom: 0.14in; line-height: 0.17in"><FONT COLOR="#00000a"><FONT FACE="Times New Roman, serif"><FONT SIZE=4><U><B>Orders</B></U></FONT></FONT></FONT></P>
<P ALIGN=JUSTIFY STYLE="margin-bottom: 0.14in; line-height: 0.17in"><FONT COLOR="#00000a"><FONT FACE="Times New Roman, serif"><FONT SIZE=4>To
make orders by users.</FONT></FONT></FONT></P>
<P ALIGN=JUSTIFY STYLE="margin-bottom: 0.14in; line-height: 0.17in"><FONT COLOR="#00000a"><FONT FACE="Times New Roman, serif"><FONT SIZE=4><U><B>Add
a purchase</B></U></FONT></FONT></FONT></P>
<P ALIGN=JUSTIFY STYLE="margin-bottom: 0.14in; line-height: 0.17in"><FONT COLOR="#00000a"><FONT FACE="Times New Roman, serif"><FONT SIZE=4>This
module enables the admin to add new books.</FONT></FONT></FONT></P>
<P ALIGN=JUSTIFY STYLE="margin-bottom: 0.14in; line-height: 0.17in"><BR><BR>
</P>
<P ALIGN=JUSTIFY STYLE="margin-bottom: 0.14in; line-height: 0.17in"><BR><BR>
</P>
<P ALIGN=JUSTIFY STYLE="margin-bottom: 0.14in; line-height: 0.17in"><FONT COLOR="#00000a"><FONT FACE="Times New Roman, serif"><FONT SIZE=4><U><B>4.
Non-Functional Requirements</B></U></FONT></FONT></FONT></P>
<P ALIGN=LEFT STYLE="margin-bottom: 0.14in; line-height: 0.17in"><FONT COLOR="#00000a"><FONT FACE="Times New Roman, serif"><FONT SIZE=3>1.
Scalability</FONT></FONT></FONT></P>
<P ALIGN=LEFT STYLE="margin-bottom: 0.14in; line-height: 0.17in"><FONT COLOR="#00000a"><FONT FACE="Times New Roman, serif"><FONT SIZE=3>2.
Reliablity.</FONT></FONT></FONT></P>
<P ALIGN=LEFT STYLE="margin-bottom: 0.14in; line-height: 0.17in"><FONT COLOR="#00000a"><FONT FACE="Times New Roman, serif"><FONT SIZE=3>3.
Maintainability</FONT></FONT></FONT></P>
<P ALIGN=LEFT STYLE="margin-bottom: 0.14in; line-height: 0.17in"><FONT COLOR="#00000a"><FONT FACE="Times New Roman, serif"><FONT SIZE=3>4.
ease of use </FONT></FONT></FONT>
</P>
<P ALIGN=LEFT STYLE="margin-bottom: 0.14in; line-height: 0.17in"><FONT COLOR="#00000a"><FONT FACE="Times New Roman, serif"><FONT SIZE=3>5.
Speed of use</FONT></FONT></FONT></P>
<P ALIGN=CENTER STYLE="margin-left: 0.5in; margin-bottom: 0.14in; line-height: 0.17in">
<BR><BR>
</P>
</BODY>
</HTML>