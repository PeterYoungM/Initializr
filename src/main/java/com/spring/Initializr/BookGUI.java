package com.spring.Initializr;

import com.spring.Initializr.domain.Book;

import java.awt.FlowLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.sql.SQLException;



public class BookGUI extends JFrame implements ActionListener
{

    private static final long serialVersionUID = 1L;

    private String title  = "";
    private String author  = "";
    private String publisher  = "";
    private int year = 0;
    private double cost = 0;
    private boolean goodInput = false;


    private static final int WIDTH = 600;
    private static final int HEIGHT = 90;

    private BookDatabase bookStore;



    public static void main(String[] args)
    {
        BookGUI gui = new BookGUI( );
        gui.setVisible(true);
    }


    public BookGUI( )
    {

        bookStore = new BookDatabase();

        JFrame frame = this;


        JMenuBar menubar = new JMenuBar();
        frame.setJMenuBar(menubar);
        frame.pack();
        frame.setVisible(true);


        JMenu fileMenu = new JMenu("File");
        menubar.add(fileMenu);


        JMenuItem quitItem = new JMenuItem("Quit");
        fileMenu.add(quitItem);
        quitItem.addActionListener(this);


        JMenu aboutMenu = new JMenu ("About");
        menubar.add(aboutMenu);

        JMenuItem infoItem = new JMenuItem("Info");
        aboutMenu.add(infoItem);
        infoItem.addActionListener(this);


        setSize(WIDTH, HEIGHT);


        Container content = getContentPane( );



        content.setLayout(new FlowLayout());


        JButton button1 = new JButton("Add Book");
        content.add(button1);
        button1.addActionListener(this);

        JButton button2 = new JButton("Cost of BookShelf");
        content.add(button2);
        button2.addActionListener(this);

        JButton button3 = new JButton("Size of BookShelf");
        content.add(button3);
        button3.addActionListener(this);

        JButton button4 = new JButton("Highest Price Paid");
        content.add(button4);
        button4.addActionListener(this);

    }


    public void actionPerformed(ActionEvent e)
    {
        if (e.getActionCommand().equals("Add Book"))
        {
            Book book = new Book("", "", 0, "", 0);
            title = JOptionPane.showInputDialog("Title");
            author = JOptionPane.showInputDialog("Author");
            publisher = JOptionPane.showInputDialog("Publisher");

            do{
                try
                {
                    cost = Double.parseDouble(JOptionPane.showInputDialog("Cost"));
                    book.setCost(cost);
                    goodInput = true;
                }
                catch (Exception cE){
                    JOptionPane.showMessageDialog(this, "Numerical entry required. Please re-enter a value for cost");
                }
            }while (!goodInput);

            goodInput = false;
            do{
                try
                {
                    year = Integer.parseInt(JOptionPane.showInputDialog("Year"));
                    book.setYear(year);
                    goodInput = true;
                }
                catch (Exception yE){
                    JOptionPane.showMessageDialog(this, "Numerical entry required. Please re-enter a value for year");
                }
            }while (!goodInput);



            book.setTitle(title);
            book.setAuthor(author);
            book.setPublisher(publisher);
 //   	    bookShelf.addBook(book);
            bookStore.saveBook(book);

            String message =  "The Title of the book is " + book.getTitle()
                    +  " the Author of the Book is "  + book.getAuthor()
                    + " it's published by " + book.getPublisher()
                    + " in " + book.getYear()
                    + " and it costs " + book.getCost() + " euro ";
            JOptionPane.showMessageDialog(null, message, "Book Details", JOptionPane.PLAIN_MESSAGE);
        }
        else if (e.getActionCommand().equals("Size of BookShelf"))
        {
            String message = "The book shelf has " + bookStore.getBookStoreSize() + " book(s)";
            JOptionPane.showMessageDialog(this, message);
        }
        else if (e.getActionCommand().equals("Cost of BookShelf"))
        {

            try {
                System.out.println(bookStore.getBookStoreTotalCost());
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
        else if (e.getActionCommand().equals("Info"))
        {
            JOptionPane.showMessageDialog(this, "Pawel Makulski - GUI Assignment Two");
        }
        else if (e.getActionCommand().equals("Highest Price Paid"))
        {
            String message = "The highest price paid for a book is: " + bookStore.getMaxPrice() + " EUR.";
            JOptionPane.showMessageDialog(this, message);
        }
        else
        {
            System.exit( 0 );
        }

    }

}

