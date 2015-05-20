package helper;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;

import java.util.Random;
import javax.imageio.ImageIO;
import javax.servlet.*;
import javax.servlet.http.*;


public class CaptchaServlet extends HttpServlet 
{

      protected void processRequest(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	  {
		
//	In the Captcha servlet, we create an image of 150*50 size.

        int width = 150;
        int height = 50;
		
//	This is an array, from which we choose our string. 

        char data[][] = 
		{
            { 'z', 'W', 'T', 'c', 'o', 'd', 'e' },
            { 'U', 'i', 'N', 'u', 'x' },
            { 'f', 'r', 'e', 'e', 'b', 's', 'd' },
            { 'u', 'K', 'Z', 'n', 'E', 'u' },
            { 'j', 'R', 'e' },
			{'T','Z','n','L','l','a'},
			{'A','T','p','1'},
			{'L','o','L','i','p','o','p'},
			{'A','j','T','c'},
			{'t','A','n','G','o'},
			{'f','a','T','a','L','e'}
        };

//	We will draw into a buffered image. 

        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        Graphics2D g2d = bufferedImage.createGraphics();

        Font font = new Font("Georgia", Font.BOLD, 18);
        g2d.setFont(font);
		
//	The rendering hints are used to increase the quality of the text. 

        RenderingHints rh = new RenderingHints( RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        g2d.setRenderingHints(rh);
		
//	Here we draw the gradient. 
        GradientPaint gp = new GradientPaint(0, 0, Color.green, 0, height/2, Color.black, true);

        g2d.setPaint(gp);
        g2d.fillRect(0, 0, width, height);

        g2d.setColor(new Color(255, 153, 0));
		
/*	
	Here we randomly choose an index into the array. We also set the chosen string into the session, so that we can compare it later to the parameter,
	specified by the user. 
*/
        Random r = new Random();
        int index = Math.abs(r.nextInt()) % 11;

        String captcha = String.copyValueOf(data[index]);
        request.getSession().setAttribute("captcha", captcha );
		
// 	This is the code that draws the string into the image. We must make sure, that the text fits into the boudaries of the image. 
        int x = 0; 
        int y = 0;

        for (int i=0; i<data[index].length; i++) 
		{
            x += 10 + (Math.abs(r.nextInt()) % 15);
            y = 20 + Math.abs(r.nextInt()) % 20;
            g2d.drawChars(data[index], i, 1, x, y);
        }

        g2d.dispose();
		
//	Finally, we return the image through a byte stream. We set a content type to png image. 

        response.setContentType("image/png");
        OutputStream os = response.getOutputStream();
        ImageIO.write(bufferedImage, "png", os);
        os.close();
      } 


      protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	  {
          processRequest(request, response);
      } 


      protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	  {
          processRequest(request, response);
      }
	  
}