package org.wcs.hello;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.tribes.util.Arrays;

@WebServlet( "/hello-form" )
public class SimpleHelloServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private String            mes;
    private String            firstname;
    private String            lastname;
    private String            time;
    private String            tabTime[];
    private String            formatTime;

    @Override
    protected void doGet( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher( "/WEB-INF/hello-form.jsp" ).forward( req, resp );
    }

    @Override
    protected void doPost( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {

        firstname = req.getParameter( "firstname" );
        lastname = req.getParameter( "lastname" );
        time = req.getParameter( "time" );
        tabTime = time.split( ":" );
        formatTime = tabTime[0] + ":" + tabTime[1];
        Integer hour = Integer.valueOf( tabTime[0].trim() );
        Integer min = Integer.valueOf( tabTime[1].trim() );
        System.out.println( "le contenu nom est : " + lastname );
        System.out.println( "le contenu prénom est : " + firstname );
        System.out.println( "le contenu time est : " + Arrays.toString( tabTime ) );
        System.out.println( "le contenu heure en Integer donne : " + hour );
        System.out.println( "le contenu min en Integer donne : " + min );
        System.out.println( "le contenu heure en entier formaté donne : " + formatTime );

        if ( hour < 12 && hour >= 5 ) {
            mes = "Good morning";
        } else if ( ( hour >= 12 ) && ( hour <= 13 ) ) {
            mes = "Good lunch";
        } else if ( ( hour > 13 ) && ( hour <= 18 ) ) {
            mes = "Good afternoon";
        } else if ( ( hour > 18 && hour < 24 ) || ( hour >= 0 && hour < 5 ) ) {
            mes = "Good night";
        }
        System.out.println( "le contenu mes après if est : " + mes );

        req.setAttribute( "message", mes );
        req.setAttribute( "lastname", lastname );
        req.setAttribute( "firstname", firstname );
        req.setAttribute( "time", formatTime );

        this.getServletContext().getRequestDispatcher( "/WEB-INF/custom-hello.jsp" ).forward( req, resp );
    }

    public String getMes() {
        return mes;
    }

    public void setMes( String mes ) {
        this.mes = mes;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname( String firstname ) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname( String lastname ) {
        this.lastname = lastname;
    }

    public String getTime() {
        return time;
    }

    public void setTime( String time ) {
        this.time = time;
    }

    public String[] getTabTime() {
        return tabTime;
    }

    public void setTabTime( String[] tabTime ) {
        this.tabTime = tabTime;
    }

    public String getFormatTime() {
        return formatTime;
    }

    public void setFormatTime( String formatTime ) {
        this.formatTime = formatTime;
    }

}
