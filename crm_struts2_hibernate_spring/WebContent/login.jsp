
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!doctype html public "-//w3c//dtd html 4.01 frameset//en" "http://www.w3c.org/tr/1999/rec-html401-19991224/frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv=content-type content="text/html; charset=utf-8">
<style type=text/css>
body {
    font-size: 12px;
    color: #ffffff;
    font-family: 宋体
}

td {
    font-size: 12px;
    color: #ffffff;
    font-family: 宋体
}
</style>

<meta content="mshtml 6.00.6000.16809" name=generator>
<script type="text/javascript">
    window.onload = function() {
        if (window.parent != window) {//如果是在框架中
            //就让框架页面跳转到登录页面
            window.parent.location.href = "${pageContext.request.contextPath}/login.jsp";
        }

    };
</script>
</head>
<body>
    <form action="SysUserAction_login" method="post">

        <div id=updatepanel1>
            <div id=div1
                style="left: 0px; position: absolute; top: 0px; background-color: #0066ff"></div>
            <div id=div2
                style="left: 0px; position: absolute; top: 0px; background-color: #0066ff"></div>


            <div>&nbsp;&nbsp;</div>
            <div>
                <table cellspacing=0 cellpadding=0 width=900 align=center border=0>
                    <tbody>
                        <tr>
                            <td style="height: 105px"><img src="images/login_1.gif"
                                border=0></td>
                        </tr>
                        <tr>
                            <td background=images/login_2.jpg height=300>
                                <table height=300 cellpadding=0 width=900 border=0>
                                    <tbody>
                                        <tr>
                                            <td colspan=2 height=35></td>
                                        </tr>
                                        <tr>
                                            <td width=360></td>
                                            <td>
                                                <table cellspacing=0 cellpadding=2 border=0>
                                                    <tbody>
                                                        <tr>
                                                            <td style="height: 28px" width=80>登 录 名：</td>
                                                            <td style="height: 28px" width=150><input
                                                                type="text" style="width: 130px" name="user.userName" /></td>

                                                            <td style="height: 28px" width=370><span
                                                                id="requiredfieldvalidator3"
                                                                style="font-weight: bold; visibility: hidden; color: white">请输入登录名</span></td>
                                                        </tr>
                                                        <tr>
                                                            <td style="height: 28px">登录密码：</td>
                                                            <td style="height: 28px"><input id=txtpwd
                                                                style="width: 130px" type="password"
                                                                name="user.userPassword"></td>
                                                            <td style="height: 28px"><span
                                                                id=requiredfieldvalidator4
                                                                style="font-weight: bold; visibility: hidden; color: white">请输入密码</span></td>
                                                        </tr>
                                                        <tr>
                                                            <td style="height: 28px">验证码：</td>
                                                            <td style="height: 28px"><input id=txtcode
                                                                style="width: 130px" name="txtcode"></td>
                                                            <td style="height: 28px">&nbsp;</td>
                                                        </tr>
                                                        <tr>
                                                            <td style="height: 18px; text-align: center"
                                                                colspan=" 2 "><font color="red">${err}</font></td>

                                                        </tr>
                                                        <tr>
                                                            <td></td>
                                                            <td><input id=btn
                                                                style="border-top-width: 0px; border-left-width: 0px; border-bottom-width: 0px; border-right-width: 0px"
                                                                onclick='javascript:webform_dopostbackwithoptions(new webform_postbackoptions("btn", "", true, "", "", false, false))'
                                                                type=image src="images/login_button.gif" name=btn>
                                                            </td>
                                                        </tr>


                                                    </tbody>
                                                </table>
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                            </td>
                        </tr>
                        <tr>
                            <td><img src="images/login_3.jpg" border=0></td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </form>
</body>
</html>
