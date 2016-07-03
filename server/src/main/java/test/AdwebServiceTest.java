package test;

import adweb.dao.Dao;
import adweb.service.AdwebService;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by Yi Zhou on 2016/7/3.
 */
@RunWith(JMock.class)
public class AdwebServiceTest {
    Mockery context;
    AdwebService adwebService;

    {
        context = new JUnit4Mockery();
        adwebService = context.mock(AdwebService.class);
    }

    @Test
    public void testAddAction(){
        mockAddAction();
        Assert.assertEquals(adwebService.addAction(1,2,3),true);
        Assert.assertEquals(adwebService.addAction(2,4,3),true);
        Assert.assertEquals(adwebService.addAction(3,2,1),true);
        Assert.assertEquals(adwebService.addAction(1,4,2),false);
        Assert.assertEquals(adwebService.addAction(2,3,3),false);
        Assert.assertEquals(adwebService.addAction(3,2,1),false);
    }

    @Test
    public void testDeleteAction(){
        mockDeleteAction();
        Assert.assertEquals(adwebService.deleteAction(1,4,2),false);
        Assert.assertEquals(adwebService.deleteAction(2,3,3),false);
        Assert.assertEquals(adwebService.deleteAction(3,2,1),false);
        Assert.assertEquals(adwebService.deleteAction(1,2,3),true);
        Assert.assertEquals(adwebService.deleteAction(2,4,3),true);
        Assert.assertEquals(adwebService.deleteAction(3,2,1),true);
    }

    @Test
    public void testRecommand(){
        mockCommand();
        Assert.assertEquals(adwebService.recommand(1),
                Maps.newHashMap(
                        ImmutableMap.of("vid","1")
                                .of("longitude","123.1311")
                                .of("latitude","31.3232")
                )
        );
        Assert.assertEquals(adwebService.recommand(2),
                Maps.newHashMap(
                        ImmutableMap.of("vid","2")
                                .of("longitude","123.5222")
                                .of("latitude","31.6322")
                )
        );
        Assert.assertEquals(adwebService.recommand(3),
                Maps.newHashMap(
                        ImmutableMap.of("vid","3")
                                .of("longitude","123.7432")
                                .of("latitude","31.5278")
                )
        );
        Assert.assertEquals(adwebService.recommand(4),
                Maps.newHashMap(
                        ImmutableMap.of("vid","4")
                                .of("longitude","123.7226")
                                .of("latitude","31.6715")
                )
        );
        Assert.assertEquals(adwebService.recommand(5),
                Maps.newHashMap(
                        ImmutableMap.of("vid","5")
                                .of("longitude","123.8212")
                                .of("latitude","31.6215")
                )
        );
        Assert.assertEquals(adwebService.recommand(6),
                Maps.newHashMap(
                        ImmutableMap.of("vid","6")
                                .of("longitude","123.7214")
                                .of("latitude","31.6244")
                )
        );


}


    public void mockCommand(){
        context.checking(new Expectations() {
            {
                oneOf(adwebService).recommand(1);
                will(returnValue(
                        Maps.newHashMap(
                                ImmutableMap.of("vid","1")
                                        .of("longitude","123.1311")
                                        .of("latitude","31.3232")
                        )
                ));
                oneOf(adwebService).recommand(2);
                will(returnValue(
                        Maps.newHashMap(
                                ImmutableMap.of("vid","2")
                                        .of("longitude","123.5222")
                                        .of("latitude","31.6322")
                        )
                ));
                oneOf(adwebService).recommand(3);
                will(returnValue(
                        Maps.newHashMap(
                                ImmutableMap.of("vid","3")
                                        .of("longitude","123.7432")
                                        .of("latitude","31.5278")
                        )
                ));
                oneOf(adwebService).recommand(4);
                will(returnValue(
                        Maps.newHashMap(
                                ImmutableMap.of("vid","4")
                                        .of("longitude","123.7226")
                                        .of("latitude","31.6715")
                        )
                ));
                oneOf(adwebService).recommand(5);
                will(returnValue(
                        Maps.newHashMap(
                                ImmutableMap.of("vid","5")
                                        .of("longitude","123.8212")
                                        .of("latitude","31.6215")
                        )
                ));
                oneOf(adwebService).recommand(6);
                will(returnValue(
                        Maps.newHashMap(
                                ImmutableMap.of("vid","6")
                                        .of("longitude","123.7214")
                                        .of("latitude","31.6244")
                        )
                ));
            }
        });
    }

    public void mockDeleteAction(){
        context.checking(new Expectations(){{
            oneOf(adwebService).deleteAction(1,4,2);
            will(returnValue(false));
            oneOf(adwebService).deleteAction(2,3,3);
            will(returnValue(false));
            oneOf(adwebService).deleteAction(3,2,1);
            will(returnValue(false));
            oneOf(adwebService).deleteAction(1,2,3);
            will(returnValue(true));
            oneOf(adwebService).deleteAction(2,4,3);
            will(returnValue(true));
            oneOf(adwebService).deleteAction(3,2,1);
            will(returnValue(true));
        }});
    }

    public void mockAddAction(){
        context.checking(new Expectations(){{
            oneOf(adwebService).addAction(1,2,3);
            will(returnValue(true));
            oneOf(adwebService).addAction(2,4,3);
            will(returnValue(true));
            oneOf(adwebService).addAction(3,2,1);
            will(returnValue(true));
            oneOf(adwebService).addAction(1,4,2);
            will(returnValue(false));
            oneOf(adwebService).addAction(2,3,3);
            will(returnValue(false));
            oneOf(adwebService).addAction(3,2,1);
            will(returnValue(false));
        }});
    }
}
