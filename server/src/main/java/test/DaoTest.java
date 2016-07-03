package test;

import adweb.dao.Dao;
import adweb.model.User;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import jdk.nashorn.internal.ir.annotations.Immutable;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Created by Yi Zhou on 2016/7/3.
 */
@RunWith(JMock.class)
public class DaoTest {
    Mockery context;
    Dao dao;

    {
        context = new JUnit4Mockery();
        dao = context.mock(Dao.class);
    }

    @Test
    public void testInsertUser(){
        mockInsertUser();
        Assert.assertEquals(dao.insert(new User("zhouyi","123456")),1);
        Assert.assertEquals(dao.insert(new User("zhouyi","123456")),-1);
        Assert.assertEquals(dao.insert(new User("jly","123456")),-2);
    }


    @Test
    public void testUpdatePortrait(){
        mockUpadtePortrait();
        User user=new User("zhouyi","123456");
        user.setPortrait("yUdjfKjodu");
        Assert.assertEquals(dao.updatePortrait(user),1);
        user.setPortrait("v_fddx");
        Assert.assertEquals(dao.updatePortrait(user),-1);
    }


    @Test
    public void testRankByCollect(){
        mockRankByCollect();
        Assert.assertEquals(dao.rankByCollect(1),
                Lists.newArrayList(
                        ImmutableMap.of("1","2"), ImmutableMap.of("3","1"),ImmutableMap.of("2","1")
                ));
        Assert.assertEquals(dao.rankByCollect(2),
                Lists.newArrayList(
                        ImmutableMap.of("4","7"), ImmutableMap.of("3","4"),ImmutableMap.of("2","1")
                ));
        Assert.assertEquals(dao.rankByCollect(3),
                Lists.newArrayList(
                        ImmutableMap.of("1","6"), ImmutableMap.of("1","3")
                ));
    }


    @Test
    public void testRankOfSearchByCollect(){
        mockRankOfSearchByCollect();
        Assert.assertEquals(dao.rankByCollect(1),
                Lists.newArrayList(
                        ImmutableMap.of("1","2").of("3","4").of("5","6"),
                        ImmutableMap.of("3","1").of("4","2").of("1","3"),
                        ImmutableMap.of("4","2")
                ));
        Assert.assertEquals(dao.rankByCollect(2),
                Lists.newArrayList(
                        ImmutableMap.of("5","12").of("3","3"),
                        ImmutableMap.of("2","5").of("4","1").of("1","3"),
                        ImmutableMap.of("7","3")
                ));
        Assert.assertEquals(dao.rankByCollect(3),
                Lists.newArrayList(
                        ImmutableMap.of("5","1").of("1","2"),
                        ImmutableMap.of("3","1").of("4","1").of("2","1"),
                        ImmutableMap.of("6","3"),
                        ImmutableMap.of("2","4").of("1","9")
                ));
    }


    @Test
    public void testGetAllComments(){
        mockGetAllComments();
        Assert.assertEquals(dao.rankByCollect(1),
                Lists.newArrayList(
                        ImmutableMap.of("1","aaaaaaa"),
                        ImmutableMap.of("3","bbbbbbb"),
                        ImmutableMap.of("4","ccccccc")
                ));
        Assert.assertEquals(dao.rankByCollect(2),
                Lists.newArrayList(
                        ImmutableMap.of("5","dddddddd"),
                        ImmutableMap.of("2","eeeeeeee"),
                        ImmutableMap.of("7","ffffffff")
                ));
        Assert.assertEquals(dao.rankByCollect(3),
                Lists.newArrayList(
                        ImmutableMap.of("5","gggggggg"),
                        ImmutableMap.of("3","hhhhhhhh"),
                        ImmutableMap.of("6","iiiiiiii"),
                        ImmutableMap.of("2","jjjjjjjj")
                ));
    }

    @Test
    public void testViewArea(){
        mockViewArea();
        Assert.assertEquals(dao.viewArea(1),
                Maps.newHashMap(
                        ImmutableMap.of("vid","1")
                            .of("longitude","123.1311")
                            .of("latitude","31.3232")
                )
        );
        Assert.assertEquals(dao.viewArea(2),
                Maps.newHashMap(
                        ImmutableMap.of("vid","2")
                                .of("longitude","123.5222")
                                .of("latitude","31.6322")
                )
        );
        Assert.assertEquals(dao.viewArea(3),
                Maps.newHashMap(
                        ImmutableMap.of("vid","3")
                                .of("longitude","123.7432")
                                .of("latitude","31.5278")
                )
        );
        Assert.assertEquals(dao.viewArea(4),
                Maps.newHashMap(
                        ImmutableMap.of("vid","4")
                                .of("longitude","123.7226")
                                .of("latitude","31.6715")
                )
        );
        Assert.assertEquals(dao.viewArea(5),
                Maps.newHashMap(
                        ImmutableMap.of("vid","5")
                                .of("longitude","123.8212")
                                .of("latitude","31.6215")
                )
        );
        Assert.assertEquals(dao.viewArea(6),
                Maps.newHashMap(
                        ImmutableMap.of("vid","6")
                                .of("longitude","123.7214")
                                .of("latitude","31.6244")
                )
        );




    }

    public void mockRankOfSearchByCollect(){
        context.checking(new Expectations() {
            {
                oneOf(dao).rankByCollect(1);
                will(returnValue(Lists.newArrayList(
                        ImmutableMap.of("1","2").of("3","4").of("5","6"),
                        ImmutableMap.of("3","1").of("4","2").of("1","3"),
                        ImmutableMap.of("4","2")
                )));
                oneOf(dao).rankByCollect(2);
                will(returnValue(Lists.newArrayList(
                        ImmutableMap.of("5","12").of("3","3"),
                        ImmutableMap.of("2","5").of("4","1").of("1","3"),
                        ImmutableMap.of("7","3")
                )));
                oneOf(dao).rankByCollect(3);
                will(returnValue(Lists.newArrayList(
                        ImmutableMap.of("5","1").of("1","2"),
                        ImmutableMap.of("3","1").of("4","1").of("2","1"),
                        ImmutableMap.of("6","3"),
                        ImmutableMap.of("2","4").of("1","9")
                )));
            }
        });
    }

    public void mockRankByCollect(){
        context.checking(new Expectations() {
            {
                oneOf(dao).rankByCollect(1);
                will(returnValue(Lists.newArrayList(
                        ImmutableMap.of("1","2"), ImmutableMap.of("3","1"),ImmutableMap.of("2","1")
                )));
                oneOf(dao).rankByCollect(2);
                will(returnValue(Lists.newArrayList(
                        ImmutableMap.of("4","7"), ImmutableMap.of("3","4"),ImmutableMap.of("2","1")
                )));
                oneOf(dao).rankByCollect(3);
                will(returnValue(Lists.newArrayList(
                        ImmutableMap.of("1","6"), ImmutableMap.of("1","3")
                )));
            }
        });
    }

    public void mockGetAllComments(){
        context.checking(new Expectations() {
            {
                oneOf(dao).rankByCollect(1);
                will(returnValue(Lists.newArrayList(
                        ImmutableMap.of("1","aaaaaaa"),
                        ImmutableMap.of("3","bbbbbbb"),
                        ImmutableMap.of("4","ccccccc")
                )));
                oneOf(dao).rankByCollect(2);
                will(returnValue(Lists.newArrayList(
                        ImmutableMap.of("5","dddddddd"),
                        ImmutableMap.of("2","eeeeeeee"),
                        ImmutableMap.of("7","ffffffff")
                )));
                oneOf(dao).rankByCollect(3);
                will(returnValue(Lists.newArrayList(
                        ImmutableMap.of("5","gggggggg"),
                        ImmutableMap.of("3","hhhhhhhh"),
                        ImmutableMap.of("6","iiiiiiii"),
                        ImmutableMap.of("2","jjjjjjjj")
                )));
            }
        });
    }

    public void mockViewArea(){
        context.checking(new Expectations() {
            {
                oneOf(dao).viewArea(1);
                will(returnValue(
                        Maps.newHashMap(
                                ImmutableMap.of("vid","1")
                                        .of("longitude","123.1311")
                                        .of("latitude","31.3232")
                        )
                ));
                oneOf(dao).viewArea(2);
                will(returnValue(
                        Maps.newHashMap(
                                ImmutableMap.of("vid","2")
                                        .of("longitude","123.5222")
                                        .of("latitude","31.6322")
                        )
                ));
                oneOf(dao).viewArea(3);
                will(returnValue(
                        Maps.newHashMap(
                                ImmutableMap.of("vid","3")
                                        .of("longitude","123.7432")
                                        .of("latitude","31.5278")
                        )
                ));
                oneOf(dao).viewArea(4);
                will(returnValue(
                        Maps.newHashMap(
                                ImmutableMap.of("vid","4")
                                        .of("longitude","123.7226")
                                        .of("latitude","31.6715")
                        )
                ));
                oneOf(dao).viewArea(5);
                will(returnValue(
                        Maps.newHashMap(
                                ImmutableMap.of("vid","5")
                                        .of("longitude","123.8212")
                                        .of("latitude","31.6215")
                        )
                ));
                oneOf(dao).viewArea(6);
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

    public void mockUpadtePortrait(){
        context.checking(new Expectations() {
            {
                oneOf(dao).updatePortrait(with(any(User.class)));will(returnValue(1));
                oneOf(dao).updatePortrait(with(any(User.class)));will(returnValue(-1));
            }
        });
    }

    public void mockInsertUser(){
        context.checking(new Expectations() {
            {
                oneOf(dao).insert(with(any(User.class)));will(returnValue(1));
                oneOf(dao).insert(with(any(User.class)));will(returnValue(-1));
                oneOf(dao).insert(with(any(User.class)));will(returnValue(-2));
            }
        });
    }


}