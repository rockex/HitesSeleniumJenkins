set projectPath=C:\Users\kiko\eclipse-workspace\HitesSelenium
cd\
cd %projectPath%
set classpath=%projectPath%\bin;%projectPath%\lib\*;
java org.testng.TestNG xml\Busqueda_producto.xml