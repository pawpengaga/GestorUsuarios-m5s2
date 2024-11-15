Implementar un sistema de **layouts** en JSP similar al de **Ruby on Rails** implica usar un enfoque en el que un archivo **layout.jsp** sirve como plantilla principal, mientras que las vistas específicas se "inyectan" en regiones dinámicas del layout, como el `<title>` y el contenido del `<body>`.

### Pasos para Implementar el Sistema de Layouts

#### 1. **Crear el archivo `layout.jsp`**
Este será el archivo principal que contendrá la estructura común de todas las páginas, incluyendo el `<head>` con una hoja de estilos común y un área dinámica para el contenido.

##### `layout.jsp`
```jsp
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><jsp:include page="${pageTitle}.jsp" /></title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <header>
        <h1>Sitio Web</h1>
        <!-- Header común -->
    </header>
    <main>
        <!-- Sección dinámica del cuerpo -->
        <jsp:include page="${view}.jsp" />
    </main>
    <footer>
        <p>&copy; 2024 - Todos los derechos reservados.</p>
    </footer>
</body>
</html>
```

- **`<jsp:include page="${view}.jsp" />`**: Incluye dinámicamente la vista.
- **`pageTitle`**: Dinamiza el título según la vista.

#### 2. **Crear las vistas específicas**
Cada vista (por ejemplo, `home.jsp`, `about.jsp`) contendrá únicamente el contenido del cuerpo.

##### `home.jsp`
```jsp
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h2>Bienvenido a la página principal</h2>
<p>Este es el contenido de la página de inicio.</p>
```

##### `about.jsp`
```jsp
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h2>Sobre nosotros</h2>
<p>Información acerca de la compañía.</p>
```

#### 3. **Modificar los Servlets**
Los Servlets deben establecer los atributos dinámicos (`view` y `pageTitle`) y redirigir siempre a `layout.jsp`.

##### Ejemplo de un Servlet para la página de inicio:
```java
package com.example;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("view", "home"); // Nombre del JSP de la vista
        request.setAttribute("pageTitle", "Inicio");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/layout.jsp");
        dispatcher.forward(request, response);
    }
}
```

##### Servlet para la página "Sobre nosotros":
```java
package com.example;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class AboutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("view", "about");
        request.setAttribute("pageTitle", "Sobre Nosotros");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/layout.jsp");
        dispatcher.forward(request, response);
    }
}
```

#### 4. **Modificar el `web.xml` para mapear los Servlets**
```xml
<web-app xmlns="http://jakarta.ee/xml/ns/jakartaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://jakarta.ee/xml/ns/jakartaee
         http://jakarta.ee/xml/ns/jakartaee/web-app_5_0.xsd"
         version="5.0">
    
    <servlet>
        <servlet-name>HomeServlet</servlet-name>
        <servlet-class>com.example.HomeServlet</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>HomeServlet</servlet-name>
        <url-pattern>/home</url-pattern>
    </servlet-mapping>

    <servlet>
        <servlet-name>AboutServlet</servlet-name>
        <servlet-class>com.example.AboutServlet</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>AboutServlet</servlet-name>
        <url-pattern>/about</url-pattern>
    </servlet-mapping>
</web-app>
```

### Flujo Final
1. **Usuario visita `/home`**: El `HomeServlet` se encarga de establecer `view=home` y `pageTitle=Inicio`.
2. El `RequestDispatcher` redirige a `layout.jsp`.
3. `layout.jsp` incluye dinámicamente `home.jsp` en el `<main>` y muestra "Inicio" como título de la página.
   
Este enfoque centraliza el layout, haciendo más fácil el mantenimiento de la estructura general del sitio.