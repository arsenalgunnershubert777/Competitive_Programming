package Problems.UVa;
//https://odzkskevi.qnssl.com/5dbcd8ca1d7ee1d26e1ed358a1766ab2?v=1537286155

import java.util.*;
public class Borrowers {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        ArrayList<String> bookList = new ArrayList<String>();
        ArrayList<String> currentBooks =  new ArrayList<String>();
        ArrayList<String> returnBooks = new ArrayList<String>();

        //take in list of books
        String word = "";
        boolean listEnd = false;
        while (!listEnd) {
            word = sc.nextLine();
            if (word.compareTo("END") != 0) {

                String book = word;

                int lastQuotation = book.indexOf('"', 1);
                String title = book.substring(1, lastQuotation);
                int startOfAuthor = book.indexOf("by", lastQuotation);
                String author = book.substring(startOfAuthor + 3);

                int placeholder = 0;
                boolean sorted = false;
                while (!sorted) {
                    if (placeholder >= bookList.size()) {
                        bookList.add(word);
                        //System.out.println("book author " + author + "PLace: " + placeholder);
                        //System.out.println("book title " + title);
                        sorted = true;
                    }
                    else {

                        String compareBook = bookList.get(placeholder);
                        int compareBookLastQuotation = compareBook.indexOf('"', 1);
                        String compareBookTitle = compareBook.substring(1, compareBookLastQuotation);
                        //System.out.println("compareTitle: " + compareBookTitle);
                        //System.out.println("title: " + title);
                        int compareBookStartOfAuthor = compareBook.indexOf("by", compareBookLastQuotation);
                        String compareBookAuthor = compareBook.substring(compareBookStartOfAuthor + 3);
                        //System.out.println("compareAuthor: " + compareBookAuthor);
                        //System.out.println("author: " + author);

                        if (author.compareTo(compareBookAuthor) < 0 || (author.compareTo(compareBookAuthor) == 0 && title.compareTo(compareBookTitle) < 0)) {
                            bookList.add(placeholder, book);
                            //System.out.println("book author 1" + author + "PLace: " + placeholder);
                            //System.out.println("book title 1" + title);
                            sorted = true;
                        }
                        placeholder++;


                    }

                }
            }
            else {

                listEnd = true;
            }
        }

        currentBooks = (ArrayList<String>) bookList.clone();

        /*for (int i = 0; i < bookList.size(); i++) {
            System.out.println(bookList.get(i));
        }*/

        //put them in correct order



        boolean processEnd = false;
        word = "";
        while (!processEnd) {
            word = sc.next();
            if (word.compareTo("BORROW") == 0) {
                String book = sc.nextLine();

                book = book.trim();
                //System.out.println("searching: " + book);
                boolean bookFound = false;
                int placeholder = 0;
                while (!bookFound) {
                    String testBook = bookList.get(placeholder);
                    if (testBook.contains(book)) {
                        currentBooks.remove(testBook);
                        bookFound = true;
                    }
                    placeholder++;
                }
            }
            else if (word.compareTo("RETURN") == 0) {
                String book = sc.nextLine();
                book = book.trim();
                boolean bookFound = false;
                int placeholder = 0;
                while (!bookFound) {
                    String testBook = bookList.get(placeholder);
                    if (testBook.contains(book)) {
                        returnBooks.add(testBook);
                        bookFound = true;
                    }
                    placeholder++;
                }

            }
            else if (word.compareTo("SHELVE" )== 0) {

                for (int j = 0; j < bookList.size(); j++) {
                    String tempBook = bookList.get(j);

                    if (!currentBooks.contains(tempBook) && returnBooks.contains(tempBook)) {
                        if (j == 0) {
                            System.out.println("Put " + tempBook.substring(0, tempBook.indexOf('"', 1) + 1) + " first");
                            currentBooks.add(tempBook);
                            returnBooks.remove(tempBook);
                        }
                        else {
                            int count = j - 1;
                            while (count >= 0) {
                                if (currentBooks.contains(bookList.get(count))) {
                                    System.out.println("Put " + tempBook.substring(0, tempBook.indexOf('"', 1) + 1) + " after " + bookList.get(count).substring(0, bookList.get(count).indexOf('"', 1) + 1));
                                            currentBooks.add(tempBook);
                                    returnBooks.remove(tempBook);
                                    break;
                                }
                                else if (count == 0) {
                                    System.out.println("Put " + tempBook.substring(0, tempBook.indexOf('"', 1) + 1) + " first");
                                    currentBooks.add(tempBook);
                                    returnBooks.remove(tempBook);
                                    break;
                                }
                                else {
                                    count--;
                                }
                            }
                        }
                    }
                    if (returnBooks.size() == 0) {
                        System.out.println("END");
                        break;
                    }
                }



            }
            else if (word.compareTo("END") == 0) {
                processEnd = true;

            }
        }




    }
}
