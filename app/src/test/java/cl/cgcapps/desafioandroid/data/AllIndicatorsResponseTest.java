package cl.cgcapps.desafioandroid.data;

import org.junit.Assert;
import org.junit.Test;

public class AllIndicatorsResponseTest {
    //Field bitcoin of type Indicator - was not mocked since Mockito doesn't mock a Final class when 'mock-maker-inline' option is not set
    //Field dolar of type Indicator - was not mocked since Mockito doesn't mock a Final class when 'mock-maker-inline' option is not set
    //Field dolarIntercambio of type Indicator - was not mocked since Mockito doesn't mock a Final class when 'mock-maker-inline' option is not set
    //Field euro of type Indicator - was not mocked since Mockito doesn't mock a Final class when 'mock-maker-inline' option is not set
    //Field imacec of type Indicator - was not mocked since Mockito doesn't mock a Final class when 'mock-maker-inline' option is not set
    //Field ipc of type Indicator - was not mocked since Mockito doesn't mock a Final class when 'mock-maker-inline' option is not set
    //Field ivp of type Indicator - was not mocked since Mockito doesn't mock a Final class when 'mock-maker-inline' option is not set
    //Field libraCobre of type Indicator - was not mocked since Mockito doesn't mock a Final class when 'mock-maker-inline' option is not set
    //Field tasaDesempleo of type Indicator - was not mocked since Mockito doesn't mock a Final class when 'mock-maker-inline' option is not set
    //Field tpm of type Indicator - was not mocked since Mockito doesn't mock a Final class when 'mock-maker-inline' option is not set
    //Field uf of type Indicator - was not mocked since Mockito doesn't mock a Final class when 'mock-maker-inline' option is not set
    //Field utm of type Indicator - was not mocked since Mockito doesn't mock a Final class when 'mock-maker-inline' option is not set
    AllIndicatorsResponse allIndicatorsResponse = new AllIndicatorsResponse("autor", new AllIndicatorsResponse.Indicator("codigo", "fecha", "nombre", "unidadMedida", 0d), new AllIndicatorsResponse.Indicator("codigo", "fecha", "nombre", "unidadMedida", 0d), new AllIndicatorsResponse.Indicator("codigo", "fecha", "nombre", "unidadMedida", 0d), new AllIndicatorsResponse.Indicator("codigo", "fecha", "nombre", "unidadMedida", 0d), "fecha", new AllIndicatorsResponse.Indicator("codigo", "fecha", "nombre", "unidadMedida", 0d), new AllIndicatorsResponse.Indicator("codigo", "fecha", "nombre", "unidadMedida", 0d), new AllIndicatorsResponse.Indicator("codigo", "fecha", "nombre", "unidadMedida", 0d), new AllIndicatorsResponse.Indicator("codigo", "fecha", "nombre", "unidadMedida", 0d), new AllIndicatorsResponse.Indicator("codigo", "fecha", "nombre", "unidadMedida", 0d), new AllIndicatorsResponse.Indicator("codigo", "fecha", "nombre", "unidadMedida", 0d), new AllIndicatorsResponse.Indicator("codigo", "fecha", "nombre", "unidadMedida", 0d), new AllIndicatorsResponse.Indicator("codigo", "fecha", "nombre", "unidadMedida", 0d), "version");

    @Test
    public void testGetAutor() throws Exception {
        String result = allIndicatorsResponse.getAutor();
        Assert.assertFalse(result, result.isEmpty());
    }

    @Test
    public void testGetBitcoin() throws Exception {
        AllIndicatorsResponse.Indicator result = allIndicatorsResponse.getBitcoin();
        Assert.assertEquals(new AllIndicatorsResponse.Indicator("codigo", "fecha", "nombre", "unidadMedida", 0d), result);
    }

    @Test
    public void testGetDolar() throws Exception {
        AllIndicatorsResponse.Indicator result = allIndicatorsResponse.getDolar();
        Assert.assertEquals(new AllIndicatorsResponse.Indicator("codigo", "fecha", "nombre", "unidadMedida", 0d), result);
    }

    @Test
    public void testGetDolarIntercambio() throws Exception {
        AllIndicatorsResponse.Indicator result = allIndicatorsResponse.getDolarIntercambio();
        Assert.assertEquals(new AllIndicatorsResponse.Indicator("codigo", "fecha", "nombre", "unidadMedida", 0d), result);
    }

    @Test
    public void testGetEuro() throws Exception {
        AllIndicatorsResponse.Indicator result = allIndicatorsResponse.getEuro();
        Assert.assertEquals(new AllIndicatorsResponse.Indicator("codigo", "fecha", "nombre", "unidadMedida", 0d), result);
    }

    @Test
    public void testGetFecha() throws Exception {
        String result = allIndicatorsResponse.getFecha();
        Assert.assertFalse(result, result.isEmpty());
    }

    @Test
    public void testGetImacec() throws Exception {
        AllIndicatorsResponse.Indicator result = allIndicatorsResponse.getImacec();
        Assert.assertEquals(new AllIndicatorsResponse.Indicator("codigo", "fecha", "nombre", "unidadMedida", 0d), result);
    }

    @Test
    public void testGetIpc() throws Exception {
        AllIndicatorsResponse.Indicator result = allIndicatorsResponse.getIpc();
        Assert.assertEquals(new AllIndicatorsResponse.Indicator("codigo", "fecha", "nombre", "unidadMedida", 0d), result);
    }

    @Test
    public void testGetIvp() throws Exception {
        AllIndicatorsResponse.Indicator result = allIndicatorsResponse.getIvp();
        Assert.assertEquals(new AllIndicatorsResponse.Indicator("codigo", "fecha", "nombre", "unidadMedida", 0d), result);
    }

    @Test
    public void testGetLibraCobre() throws Exception {
        AllIndicatorsResponse.Indicator result = allIndicatorsResponse.getLibraCobre();
        Assert.assertEquals(new AllIndicatorsResponse.Indicator("codigo", "fecha", "nombre", "unidadMedida", 0d), result);
    }

    @Test
    public void testGetTasaDesempleo() throws Exception {
        AllIndicatorsResponse.Indicator result = allIndicatorsResponse.getTasaDesempleo();
        Assert.assertEquals(new AllIndicatorsResponse.Indicator("codigo", "fecha", "nombre", "unidadMedida", 0d), result);
    }

    @Test
    public void testGetTpm() throws Exception {
        AllIndicatorsResponse.Indicator result = allIndicatorsResponse.getTpm();
        Assert.assertEquals(new AllIndicatorsResponse.Indicator("codigo", "fecha", "nombre", "unidadMedida", 0d), result);
    }

    @Test
    public void testGetUf() throws Exception {
        AllIndicatorsResponse.Indicator result = allIndicatorsResponse.getUf();
        Assert.assertEquals(new AllIndicatorsResponse.Indicator("codigo", "fecha", "nombre", "unidadMedida", 0d), result);
    }

    @Test
    public void testGetUtm() throws Exception {
        AllIndicatorsResponse.Indicator result = allIndicatorsResponse.getUtm();
        Assert.assertEquals(new AllIndicatorsResponse.Indicator("codigo", "fecha", "nombre", "unidadMedida", 0d), result);
    }

    @Test
    public void testGetVersion() throws Exception {
        String result = allIndicatorsResponse.getVersion();
        Assert.assertFalse(result, result.isEmpty());
    }

    @Test
    public void testCopy() throws Exception {
        AllIndicatorsResponse result = allIndicatorsResponse.copy("autor", new AllIndicatorsResponse.Indicator("codigo", "fecha", "nombre", "unidadMedida", 0d), new AllIndicatorsResponse.Indicator("codigo", "fecha", "nombre", "unidadMedida", 0d), new AllIndicatorsResponse.Indicator("codigo", "fecha", "nombre", "unidadMedida", 0d), new AllIndicatorsResponse.Indicator("codigo", "fecha", "nombre", "unidadMedida", 0d), "fecha", new AllIndicatorsResponse.Indicator("codigo", "fecha", "nombre", "unidadMedida", 0d), new AllIndicatorsResponse.Indicator("codigo", "fecha", "nombre", "unidadMedida", 0d), new AllIndicatorsResponse.Indicator("codigo", "fecha", "nombre", "unidadMedida", 0d), new AllIndicatorsResponse.Indicator("codigo", "fecha", "nombre", "unidadMedida", 0d), new AllIndicatorsResponse.Indicator("codigo", "fecha", "nombre", "unidadMedida", 0d), new AllIndicatorsResponse.Indicator("codigo", "fecha", "nombre", "unidadMedida", 0d), new AllIndicatorsResponse.Indicator("codigo", "fecha", "nombre", "unidadMedida", 0d), new AllIndicatorsResponse.Indicator("codigo", "fecha", "nombre", "unidadMedida", 0d), "version");
        Assert.assertEquals(new AllIndicatorsResponse("autor", new AllIndicatorsResponse.Indicator("codigo", "fecha", "nombre", "unidadMedida", 0d), new AllIndicatorsResponse.Indicator("codigo", "fecha", "nombre", "unidadMedida", 0d), new AllIndicatorsResponse.Indicator("codigo", "fecha", "nombre", "unidadMedida", 0d), new AllIndicatorsResponse.Indicator("codigo", "fecha", "nombre", "unidadMedida", 0d), "fecha", new AllIndicatorsResponse.Indicator("codigo", "fecha", "nombre", "unidadMedida", 0d), new AllIndicatorsResponse.Indicator("codigo", "fecha", "nombre", "unidadMedida", 0d), new AllIndicatorsResponse.Indicator("codigo", "fecha", "nombre", "unidadMedida", 0d), new AllIndicatorsResponse.Indicator("codigo", "fecha", "nombre", "unidadMedida", 0d), new AllIndicatorsResponse.Indicator("codigo", "fecha", "nombre", "unidadMedida", 0d), new AllIndicatorsResponse.Indicator("codigo", "fecha", "nombre", "unidadMedida", 0d), new AllIndicatorsResponse.Indicator("codigo", "fecha", "nombre", "unidadMedida", 0d), new AllIndicatorsResponse.Indicator("codigo", "fecha", "nombre", "unidadMedida", 0d), "version"), result);
    }

    @Test
    public void testToString() throws Exception {
        String result = allIndicatorsResponse.toString();
        Assert.assertFalse(result, result.isEmpty());
    }

}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme