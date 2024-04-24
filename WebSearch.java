/*****************************************************
 *** Java program for querying yahoo search engine ***
 *** Partially written by chatgpt                  ***
 *****************************************************/

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

public class WebSearch {

    // Array for tracking appearances of int
    private static String[] names = new String[2000];
    private static int[] counts = new int[2000];
    private static int index;
    private static String query;

    public static void main(String[] args) {
        // initialize array
        for (int i=0; i<2000; i++)
        {
          counts[i] = 0;
        }
        index = 0;

        //Input query here
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your natural language question.");
        System.out.println("The answer should be a two word name.");
        query = scan.nextLine();
        String q = replaceSpaces(query);

        try {
            // Fetch Google search results
            String html = fetchHTML("https://search.yahoo.com/search?p=" + q);
            html = extractTextFromHTML(html);
            extractNames(html);
            displayResults();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to fetch HTML content from a URL
    private static String fetchHTML(String urlString) throws IOException {
        StringBuilder html = new StringBuilder();
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            html.append(line);
        }
        reader.close();

        return html.toString();
    }


    public static String extractTextFromHTML(String htmlContent) {
        // Remove HTML tags
        String text = htmlContent.replaceAll("<[^>]*>", "");

        // Remove special characters
        text = text.replaceAll("&\\S*?;", "");

        // Remove extra whitespaces and trim
        //text = text.replaceAll("\\s+", " ").trim();

        return text;
    }


    private static String replaceSpaces(String s)
    {
      String rv = "";
      for (int i=0; i<s.length(); i++)
      {
        char ch = s.charAt(i);
        if (ch == ' ')
        {
          rv += "+"; 
        }
        else
        {
          rv += ch;
        }      
      }
      return rv;
    }


    private static void extractNames(String s)
    {
      StringTokenizer st = new StringTokenizer(s);
      boolean possibleName = false;
      String prev = "";
      while (st.hasMoreTokens())
      {
        String token = extractLetters(st.nextToken());
        if (token.length() >= 1)
        {
          char ch = token.charAt(0);
          if ((ch >= 'A') && (ch <= 'Z'))
          {
            if (possibleName)
            {
              String candidate = prev + " " + token;
              if ((query.toUpperCase().indexOf(prev.toUpperCase()) < 0) && (query.toUpperCase().indexOf(token.toUpperCase()) < 0))
              {
                int x = find(candidate);
                if (x >= 0)
                {
                  counts[x]++;
                }
                else
                {
                  names[index] = candidate;
                  counts[index]++;
                  index++;
                }
              }
              prev = token;
            }
            else
            {
              possibleName = true;
              prev = token;
            }
          }
          else
          {
            possibleName = false;
            prev = "";
          }
        }
      }
    }


    private static String extractLetters(String token)
    {
      String rv = "";
      for (int a=0; a<token.length(); a++)
      {
        char c = token.charAt(a);
        if ( ((c >= 'A') && (c <= 'Z')) || ((c >= 'a') && (c <= 'z')) )
        {
          rv += c;
        }
      }
      return rv;
    }


    private static int find(String test)
    {
      int rv = -1;
      for (int i=0; i<index; i++)
      {
        if (names[i].equals(test))
        {
          rv = i;
        }
      }
      return rv;
    }


    private static void displayResults()
    {
      for (int j=index; j>1; j--)
      {
        for (int i=0; i<j; i++)
        {
          if (counts[i] < counts[i+1])
          {
            int t = counts[i];
            counts[i] = counts[i+1];
            counts[i+1] = t;
            String ts = names[i];
            names[i] = names[i+1];
            names[i+1] = ts;
          }
        }
      }

      for (int i=0; i<5; i++)
      {
        System.out.println(names[i] + " " + counts[i]);
      }
    }
}
