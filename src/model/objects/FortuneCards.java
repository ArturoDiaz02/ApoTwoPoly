package objects;


public class FortuneCards extends WildCards {
    
	private static final long serialVersionUID = 452370941377952700L;
	private String card;
    private int idAction;

    public FortuneCards(String card, int typeAction) {
        this.card = card;
        this.idAction = typeAction;
    }

    public FortuneCards() {}

    public String getCard() {
        return this.card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public int getIdAction() {
        return this.idAction;
    }

    public void setIdAction(int typeAction) {
        this.idAction = typeAction;
    }

    @Override
    public Board action(Board board){

        int aux = 0;
       


        switch(idAction){
            case 1:

                board.getPlayers().get(board.getTurn()).setPosition(1);
                board = setMoney(board, 200);
                board.getPlayers().get(board.getTurn()).setJail(true);
                break;
            
            case 2:
                board.getPlayers().get(board.getTurn()).setPosition(board.getPlayers().get(board.getTurn()).getPosition() - 3);
                board.getPlayers().get(board.getTurn()).setJail(true);
                break;
            
            case 3:
                board = setMoney(board, 100);
                break;
            
            case 4:
                board = setMoney(board, -50);
                //ver si puede pagar
                break;
            
            case 5:
                board.getPlayers().get(board.getTurn()).setEspecialCards(true);
                break;
            
            case 6:
                board = setMoney(board, 150);
                break;

            case 7:
                board.getPlayers().get(board.getTurn()).setPosition(0);
                board = setMoney(board, 200);
                board.getPlayers().get(board.getTurn()).setJail(true);
                break;

            case 8:
                
                for(int i =  board.getPlayers().get(board.getTurn()).getPosition(); i < 39; i++){

                    if(i == 5){
                        board.getPlayers().get(board.getTurn()).setPosition(5);

                    }else if(i == 15){
                        board.getPlayers().get(board.getTurn()).setPosition(15);

                    }else if(i == 25){
                        board.getPlayers().get(board.getTurn()).setPosition(25);

                    }else if(i == 35){
                        board.getPlayers().get(board.getTurn()).setPosition(35);

                    }

                }

                break;

            case 9:
                board = setMoney(board, -15);
                //ver si puede pagar
                break;

            case 10:

                board.getPlayers().get(board.getTurn()).setPosition(10);
                board.getPlayers().get(board.getTurn()).setPenalty(3);
                board.getPlayers().get(board.getTurn()).setJail(true);
                board.getCommunSquare().get(2).getJail().add(board.getPlayers().get(board.getTurn()));
                break;

            case 11:
                
                aux = 0;

                for(Properties propertie : board.getPlayers().get(board.getTurn()).getProperties().toArray()){
                    aux += propertie.getHouses()*25;
                    aux += (propertie.getHotel())? 100 : 0;
            
                }
        
                board = setMoney(board,  aux);
                break;

            case 12:
                board.getPlayers().get(board.getTurn()).setPosition(23);
                board.getPlayers().get(board.getTurn()).setJail(true);
                break;

            case 13:
                board = setMoney(board, 50);
                break;

            case 14:

                for(Token player : board.getPlayers().toArray()){
                    player.setMoney(player.getMoney() + 25);
                    aux++;

                }

                board = setMoney(board, -25*(aux));
                //ver si puede pagar
            break;


        }
        
        return board;

    }

    @Override
    public Board setMoney(Board board, int aux){
        board.getPlayers().get(board.getTurn()).setMoney(board.getPlayers().get(board.getTurn()).getMoney() + aux);

        return board;
    }
    
}
