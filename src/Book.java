public class Book {
    // Book.java

        private String nbook;
        private int quantity;
        private String authorName;

        // Constructor
        public Book(String nbook, String authorName, int quantity) {
            this.nbook = nbook;
            this.authorName = authorName;
            this.quantity = quantity;
        }

        // Getters and setters
        public String getNbook() {
            return nbook;
        }

        public void setNbook(String nbook) {
            this.nbook = nbook;
        }

        public String getAuthorName() {
            return authorName;
        }

        public void setAuthorName(String authorName) {
            this.authorName = authorName;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }


        public void displayBookInfo() {
            System.out.println("Book Title: " + nbook);
            System.out.println("Author: " + authorName);
            System.out.println("Quantity: " + quantity);
        }


        public boolean loanBook() {
            if (quantity > 0) {
                quantity--;
                return true;
            }
            return false;
        }

        public void returnBook() {
            quantity++;
        }
    }


