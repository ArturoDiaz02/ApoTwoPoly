package ui;

import model.objects.Board;
import model.objects.CommunSquare;
import model.objects.CommunityServiceCards;
import model.objects.FortuneCards;
import model.objects.Properties;
import model.objects.WildCards;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import model.data_structure.MeLinkedLists;

public class Load {

    private ObjectOutputStream oos;
    private Board board;

    public Load(){}

    public void escribir() throws IOException, ClassNotFoundException{
        

        board = new Board(new MeLinkedLists<>(), new MeLinkedLists<>(), new MeLinkedLists<>() , new MeLinkedLists<>(), new MeLinkedLists<>(), new MeLinkedLists<>());
        board.getCommunSquare().add(new CommunSquare(1, 2, 1));
        int[][] valors1 = {{0,10},{0,30},{0,90},{0,160},{0,250}};
        int[] valors2 = {50, 50};
        board.getPropertiesSquare().add(new Properties("properties\\SanLuisNorte.jpg", 0, 2, valors1, valors2 , 30, 2, 0));
        board.getWildCardsSquare().add(new WildCards(3, 1, true));
        int[][] valors3 = {{0,20},{0,60},{0,180},{0,320},{0,450}};
        board.getPropertiesSquare().add(new Properties("properties\\SanLuisSur.jpg", 0, 4, valors3, valors2, 30, 4, 0));
        board.getCommunSquare().add(new CommunSquare(5, 2, 5));
        int[][] valors4 = {{0,25},{0,50},{0,100},{0,200}};
        int[] valors5 = {0, 0};
        board.getPropertiesSquare().add(new Properties("properties\\TrenNorte.jpg", 0, 25, valors4, valors5, 100, 6, 0));//ajustar
        int[][] valors6 = {{0,30},{0,90},{0,270},{0,400},{0,550}};
        board.getPropertiesSquare().add(new Properties("properties\\FormosaEste.jpg", 0, 6, valors6, valors2, 50, 7, 0));
        board.getWildCardsSquare().add(new WildCards(8, 1, false));
        board.getPropertiesSquare().add(new Properties("properties\\FormosaNorte.jpg", 0, 6, valors6, valors2, 50, 9, 0));
        int[][] valors7 = {{0,40},{0,100},{0,300},{0,450},{0,600}};
        board.getPropertiesSquare().add(new Properties("properties\\FormosaSur.jpg", 0, 8, valors7, valors2, 60, 10, 0));
        board.getCommunSquare().add(new CommunSquare(11, 2, 3));
        int[][] valors8 = {{0,50},{0,150},{0,450},{0,625},{0,750}};
        int[] valors9 = {100, 100};
        board.getPropertiesSquare().add(new Properties("properties\\SanJuanEste.jpg", 0, 10, valors8, valors9, 70, 12, 0));
        board.getPropertiesSquare().add(new Properties("properties\\Electricidad.jpg", 0, 10, valors8, valors9, 70, 13, 0));//ajustar
        board.getPropertiesSquare().add(new Properties("properties\\SanJuanSur.jpg", 0, 10, valors8, valors9, 70, 14, 0));
        int[][] valors10 = {{0,60},{0,80},{0,500},{0,700},{0,900}};
        board.getPropertiesSquare().add(new Properties("properties\\SanJuanNorte.jpg", 0, 12, valors10, valors9, 80, 15, 0));
        board.getPropertiesSquare().add(new Properties("properties\\TrenOeste.jpg", 0, 25, valors10, valors9, 100, 16, 0));//ajustar
        int[][] valors11 = {{0,70},{0,200},{0,550},{0,750},{0,950}};
        board.getPropertiesSquare().add(new Properties("properties\\NeuquenEste.jpg", 0, 14, valors11, valors9, 90, 17, 0));
        board.getWildCardsSquare().add(new WildCards(18, 1, true));
        board.getPropertiesSquare().add(new Properties("properties\\NeuquenSur.jpg", 0, 14, valors11, valors9, 90, 19, 0));
        int[][] valors12 = {{0,80},{0,220},{0,600},{0,800},{0,1000}};
        board.getPropertiesSquare().add(new Properties("properties\\NeuquenNorte.jpg", 0, 16, valors12, valors9, 100, 20, 0));
        board.getCommunSquare().add(new CommunSquare(21, 2, 4));
        int[][] valors13 = {{0,90},{0,250},{0,700},{0,875},{0,1050}};
        int[] valors14 = {150, 150};
        board.getPropertiesSquare().add(new Properties("properties\\MendozaEste.jpg", 0, 18, valors13, valors14, 110, 22, 0));
        board.getWildCardsSquare().add(new WildCards(23, 1, false));
        board.getPropertiesSquare().add(new Properties("properties\\MendozaSur.jpg", 0, 18, valors13, valors14, 110, 24, 0));
        int[][] valors15 = {{0,100},{0,300},{0,750},{0,925},{0,1100}};
        board.getPropertiesSquare().add(new Properties("properties\\MendozaNorte.jpg", 0, 20, valors15, valors14, 120, 25, 0));
        board.getPropertiesSquare().add(new Properties("properties\\TrenEste.jpg", 0, 25, valors10, valors9, 100, 26, 0));//ajustar
        int[][] valors16 = {{0,110},{0,330},{0,800},{0,975},{0,1150}};
        board.getPropertiesSquare().add(new Properties("properties\\SantaFeEste.jpg", 0, 22, valors16, valors14, 130, 27, 0));
        board.getPropertiesSquare().add(new Properties("properties\\SantaFeSur.jpg", 0, 22, valors16, valors14, 130, 28, 0));
        board.getPropertiesSquare().add(new Properties("properties\\Agua.jpg", 0, 10, valors8, valors9, 70, 29, 0));//ajustar
        int[][] valors17 = {{0,120},{0,360},{0,850},{0,1025},{0,1200}};
        board.getPropertiesSquare().add(new Properties("properties\\SantaFeNorte.jpg", 0, 24, valors17, valors14, 140, 30, 0));
        board.getCommunSquare().add(new CommunSquare(31, 2, 2));
        int[][] valors18 = {{0,130},{0,390},{0,900},{0,1100},{0,1275}};
        int[] valors19 = {200, 200};
        board.getPropertiesSquare().add(new Properties("properties\\CordobaEste.jpg", 0, 26, valors18, valors19, 150, 32, 0));
        board.getPropertiesSquare().add(new Properties("properties\\CordobaSur.jpg", 0, 26, valors18, valors19, 150, 33, 0));
        board.getWildCardsSquare().add(new WildCards(34, 1, true));
        int[][] valors20 = {{0,150},{0,450},{0,1000},{0,1200},{0,1400}};
        board.getPropertiesSquare().add(new Properties("properties\\CordobaNorte.jpg", 0, 28, valors20, valors19, 160, 35, 0));
        board.getPropertiesSquare().add(new Properties("properties\\TrenSur.jpg", 0, 25, valors10, valors9, 100, 36, 0));//ajustar
        board.getWildCardsSquare().add(new WildCards(37, 1, false));
        int[][] valors21 = {{0,175},{0,500},{0,1100},{0,1300},{0,1500}};
        board.getPropertiesSquare().add(new Properties("properties\\BuenosAiresNorte.jpg", 0, 35, valors21, valors19, 175, 38, 0));
        board.getCommunSquare().add(new CommunSquare(39, 2, 5));
        int[][] valors22 = {{0,200},{0,600},{0,1400},{0,1700},{0,2000}};
        board.getPropertiesSquare().add(new Properties("properties\\BuenosAiresSur.jpg", 0, 50, valors22, valors19, 200, 40, 0));


        board.getCommunityServiceCards().add(new CommunityServiceCards("cards\\community\\1.jpg", 1));
        board.getCommunityServiceCards().add(new CommunityServiceCards("cards\\community\\2.jpg", 2));
        board.getCommunityServiceCards().add(new CommunityServiceCards("cards\\community\\3.jpg", 3));
        board.getCommunityServiceCards().add(new CommunityServiceCards("cards\\community\\4.jpg", 4));
        board.getCommunityServiceCards().add(new CommunityServiceCards("cards\\community\\5.jpg", 5));
        board.getCommunityServiceCards().add(new CommunityServiceCards("cards\\community\\6.jpg", 6));
        board.getCommunityServiceCards().add(new CommunityServiceCards("cards\\community\\7.jpg", 7));
        board.getCommunityServiceCards().add(new CommunityServiceCards("cards\\community\\8.jpg", 8));
        board.getCommunityServiceCards().add(new CommunityServiceCards("cards\\community\\9.jpg", 9));
        board.getCommunityServiceCards().add(new CommunityServiceCards("cards\\community\\10.jpg", 10));
        board.getCommunityServiceCards().add(new CommunityServiceCards("cards\\community\\11.jpg", 11));
        board.getCommunityServiceCards().add(new CommunityServiceCards("cards\\community\\12.jpg", 12));
        board.getCommunityServiceCards().add(new CommunityServiceCards("cards\\community\\13.jpg", 13));
        board.getCommunityServiceCards().add(new CommunityServiceCards("cards\\community\\14.jpg", 14));

        board.getFortuneCards().add(new FortuneCards("cards\\fortune\\1.jpg", 1));
        board.getFortuneCards().add(new FortuneCards("cards\\fortune\\2.jpg", 2));
        board.getFortuneCards().add(new FortuneCards("cards\\fortune\\3.jpg", 3));
        board.getFortuneCards().add(new FortuneCards("cards\\fortune\\4.jpg", 4));
        board.getFortuneCards().add(new FortuneCards("cards\\fortune\\5.jpg", 5));
        board.getFortuneCards().add(new FortuneCards("cards\\fortune\\6.jpg", 6));
        board.getFortuneCards().add(new FortuneCards("cards\\fortune\\7.jpg", 7));
        board.getFortuneCards().add(new FortuneCards("cards\\fortune\\8.jpg", 8));
        board.getFortuneCards().add(new FortuneCards("cards\\fortune\\9.jpg", 9));
        board.getFortuneCards().add(new FortuneCards("cards\\fortune\\10.jpg", 10));
        board.getFortuneCards().add(new FortuneCards("cards\\fortune\\11.jpg", 11));
        board.getFortuneCards().add(new FortuneCards("cards\\fortune\\12.jpg", 12));
        board.getFortuneCards().add(new FortuneCards("cards\\fortune\\13.jpg", 13));
        board.getFortuneCards().add(new FortuneCards("cards\\fortune\\14.jpg", 14));
    

        oos = new ObjectOutputStream(new FileOutputStream("data\\Data.txt"));
        oos.writeObject(board);
        oos.close();

    }
    
}
