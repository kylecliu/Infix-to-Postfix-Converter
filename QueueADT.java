/**
*This class implements the queue abstract data type using stacks.
*@author Chun-Hsien Liu
*@version ver 1.0.0
*Some print statements are commented out deliberately for demonstration purposes to prevent repeated messages when testing other classes. Please uncomment them when validating this class.
*/
public class QueueADT
{   
    private StackADT front;
    private StackADT rear;
    private StackADT.StackNode tail;

    /**
    *Default constructor.
    */
    public QueueADT()
    {
        front = new StackADT();
        rear = new StackADT();
    }

    /**
    *Accessor that returns the front stack.
    *
    *@return    the front stack.
    */
    public StackADT getFront()
    {
        return front;
    }

    /**
    *Accessor that returns the rear stack.
    *
    *@return    the rear stack.
    */
    public StackADT getRear()
    {
        return rear;
    }

    /**
    *Accessor that returns the tail node in the front stack.
    *
    *@return    the tail as a node.
    */
    public StackADT.StackNode getTail()
    {
        return tail;
    }

    /**
    *This method adds an item to the back of the queue.
    *
    *@param     accepts a String.
    */
    public void enqueue(String input)
    {
        if(rear.isEmpty())
        {
            rear.push(input);
            front.push(input);
            tail = front.getHeader();

        }
        else
        {
            rear.push(input);

            StackADT.StackNode node = new StackADT.StackNode();
            node.setData(rear.getHeader().getData());
            tail.setNext(node);
            tail = node;
        }
    }

    /**
    *This method removes and returns an item from the front of the queue.
    *
    *@return    a String.
    */
    public String dequeue()
    {
        if(front.isEmpty())
        {
            System.out.println("This queue is empty");
            return null;
        }
        else
        {
            String value = front.getHeader().getData();
            front.pop();
            // System.out.println(value + " has been removed from the queue");
            return value;
        }
    }

    /**
    *This method returns tha value at the front of the queue without removing it.
    *
    *@return    a String value.
    */
    public String queueFront()
    {
        System.out.println("The value at the front of the queue is " + front.getHeader().getData());
        return front.getHeader().getData();
    }

    /**
    *This method indicates if the queue is empty.
    *
    *@return    a boolean value indicating if the queue is empty. 
    */
    public boolean isEmpty()
    {
        if(front.isEmpty())
        {
            // System.out.println("This queue is empty");
            return true;
        }
        else
        {
            // System.out.println("This queue is not empty");
            return false;
        }
    }

    /**
    *This method displays the values inside the queue.
    */
    public void print()
    {
        if(front.isEmpty())
        {
            System.out.println("This queue is empty");
        }
        else
        {
            front.print();
        }
    }

    /**
    *Main method including sample testing code.
    */
    public static void main(String[] args)
    {
        // QueueADT queue = new QueueADT();
        // queue.isEmpty();
        // queue.print();
        // queue.enqueue("A");
        // queue.enqueue("B");
        // queue.enqueue("C");
        // queue.isEmpty();
        // queue.print();
        // queue.queueFront();
        // queue.dequeue();
        // queue.print();
        // queue.dequeue();
        // queue.dequeue();
        // queue.print();
    }

    

}