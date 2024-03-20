

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * A classe de teste CompanyTest.
 *
 * @author  (seu nome)
 * @version (um número da versão ou uma data)
 */
public class CompanyTest
{
    Company company;
    User client1;
    User client2;
    User seller1;
    User seller2;
    
    /**
     * Construtor default para a classe de teste CompanyTest
     */
    public CompanyTest()
    {

    }

    @Test
    public void testConstrutor()
    {
        assertNotNull(company.getClients());
        assertNotNull(company.getSellers());
    }
    
    @Test
    public void testRegisterClient()
    {
        client1 = new User("José Manuel", "911111111", "zemanel@yahoo.com");
        company.registerClient(client1);
        
        assertEquals(false, company.registerClient(client1));
    }
    
    @Test
    public void testRegisterClients()
    {
        client1 = new User("José Manuel", "911111111", "zemanel@yahoo.com");
        company.registerClient(client1);
        
        client2 = new User("António Francisco", "922222222", "tochico@hotmail.com");
        company.registerClient(client2);
        
        assertEquals(false, company.registerClient(client1));
        assertEquals(false, company.registerClient(client2));
    }
    
    @Test
    public void testRegisterClientDuplicate()
    {
        client1 = new User("José Manuel", "911111111", "zemanel@yahoo.com");
        //company.registerClient(client1);
        assertTrue(company.registerClient(client1));
        
        //company.registerClient(client1);
        assertFalse(company.registerClient(client1));
    }
    
    @Test
    public void testRegisterClientNull()
    {
        assertFalse(company.registerClient(null));
    }
    
    /////////////////////////////////////////////////////////////////
    
    @Test
    public void testRegisterSeller()
    {
        seller1 = new User("Fernando Fernandes", "966777101", "fefe@remax.pt");
        company.registerSeller(seller1);
        
        assertEquals(false, company.registerSeller(seller1));
    }
    
    @Test
    public void testRegisterSellers()
    {
        seller1 = new User("Fernando Fernandes", "966777101", "fefe@remax.pt");
        company.registerSeller(seller1);
           
        seller2 = new User("Rodrigo Rodrigues", "966777152", "roro@remax.pt");
        company.registerSeller(seller2);
        
        assertEquals(false, company.registerSeller(seller1));
        assertEquals(false, company.registerSeller(seller2));
    
    }
    
    @Test
    public void testRegisterSellerDuplicate()
    {
        seller1 = new User("Fernando Fernandes", "966777101", "fefe@remax.pt");
        
        assertTrue(company.registerSeller(seller1));
        
        assertFalse(company.registerSeller(seller1));
    }
    
    @Test
    public void testRegisterSellerNull()
    {
        assertFalse(company.registerSeller(null));
    }
    
    /**
     * Define a 'fixture' do teste.
     *
     * Chamado antes de cada método de caso de teste.
     */
    @BeforeEach
    public void setUp()
    {
        company = new Company();
        
        company.registerSeller(seller1);
        company.registerSeller(seller2);
    }

    /**
     * Desfaz a 'fixture' do teste.
     *
     * Chamado após cada método de teste de caso.
     */
    @AfterEach
    public void tearDown()
    {
    }
}
