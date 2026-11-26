public class ProdConsBuffer implements IProdConsBuffer {

    private int size;
    private Message[] buffer;
    private boolean full;
    private boolean empty;
    private int nmsg;
    private int totmsg;

    public ProdConsBuffer (){
        size = 2000;
        buffer = new Message[size];
        full = false;
    }

    public ProdConsBuffer (int size){
        this.size = size;
        buffer = new Message[size]; 
        full = false;
    }

    @Override
    public void put(Message m) throws InterruptedException {
        while(full){
            wait();
        }
        empty = false;
        buffer.push(m);
        nmsg++;
        totmsg++;
        //if buffer plein full = true
    }

    @Override
    public Message get() throws InterruptedException {
        while(empty){
            wait();
        }
        // buffer vide empty = true
        full = false;
        nmsg--;
        return buffer.pop();
    }

    @Override
    public int nmsg() {
        return nmsg;
    }

    @Override
    public int totmsg() {
        return totmsg;
    }


    
}