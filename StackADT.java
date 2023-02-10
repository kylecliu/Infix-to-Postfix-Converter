/**
*This class implements the stack abstract data type using a linked list.
*@author Chun-Hsien Liu
*@version ver 1.0.0
*Some print statements are commented out deliberately for demonstration purposes to prevent repeated messages when testing other classes. Please uncomment them when validating this class.
*/
public class StackADT
{
    /**
    *Nested class which implements nodes.
    */
    public static class StackNode
    {
        private String data;
        private StackNode next;

        /**
        *Default constructor.
        */
        public StackNode()
        {
            data = "";
            next = null;
        }

        /**
        *Non-default constructor.
        */
        public StackNode(String data)
        {
            this.data = data;
            next = null;
        }

        /**
        *Accessor method that returns the value stored inside the node.
        *
        *@return   the value of the node as a String. 
        */
        public String getData()
        {
            return data;
        }

        /**
        *Accessor method that returns the reference to the next node.
        *
        *@return   the next node. 
        */
        public StackNode getNext()
        {
            return next;
        }

        /**
        *Mutator method that updates the value stored inside the node.
        *
        *@param   accepts the value of the node as a String. 
        */
        public void setData(String data)
        {
            this.data = data;
        }

        /**
        *Mutator method that updates the reference to the next node.
        *
        *@param   accepts the next node. 
        */
        public void setNext(StackNode next)
        {
            this.next = next;
        }

    }

    private StackNode header;   

    /**
    *Default constructor.
    */
    public StackADT()
    {

    }

    /**
    *Non-default constructor.
    */
    public StackADT(StackNode nd)
    {
        header = nd;
    }

    /**
    *Accessor method that returns the header.
    *
    *@return the header as node.
    */
    public StackNode getHeader()
    {
        return header;
    }

    /**
    *This method adds an item onto the stack.
    *
    *@param accepts a String
    */ 
    public void push(String input)
    {
       StackNode node = new StackNode();
       node.setData(input);
      
      if(header == null)
      {
          node.setNext(null);
      }
      else
      {
          node.setNext(header);
      }

      header = node;

    }

    /**
    *This method removes an item from the top the stack. 
    */
    public void pop()
    {
        if(header == null)
        {
            System.out.println("This stack is empty");
        }
        else
        {
            StackNode prevNode = new StackNode();
            prevNode = header.getNext();
            header = prevNode;
        }
    }

    /**
    *This method returns the item at the top of the stack without removing it.
    *@return    the item at the top of the stack as a String
    */
    public String stackTop()
    {
        if(header == null)
        {
            // System.out.println("There is no value in this stack");
            return null;
        }
        else
        {
            // System.out.println("The top value of this stack is " + header.getData());
            return header.getData();
        }
    }

    /**
    *This method indicates if the stack is empty.
    *
    *@return    a boolean value indicating if the stack is empty
    */
    public boolean isEmpty()
    {
        if(header == null)
        {
            // System.out.println("This stack is empty");
            return true;
        }
        else
        {
            // System.out.println("This stack is not empty");
            return false;
        }
    }

    /**
    *This method displays the String values that are stored in the stack.
    */
    public void print()
    {
        StackNode temp = new StackNode();
        temp = header;

        if(temp == null)
        {
            System.out.println("This stack is empty");
            return;
        }

        // System.out.println("This stack contains:");

        while(temp != null)
        {
            System.out.print(temp.getData() + " ");
            temp = temp.getNext();
        }

        System.out.println();
    }

    /**
    *Main method including sample testing code.
    */
    public static void main(String[] args)
    {
        // StackADT stack = new StackADT();
        // stack.print();
        // stack.isEmpty();
        // stack.push("A");
        // stack.push("B");
        // stack.push("C");
        // stack.isEmpty();
        // stack.print();
        // stack.pop();
        // stack.print();
        // stack.pop();
        // stack.print();
        // stack.pop();
        // stack.isEmpty();
        // stack.print();
    }   
}