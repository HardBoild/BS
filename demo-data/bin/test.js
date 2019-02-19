/**
 * Created by Mengyuan.Yu on 2019/2/15.
 */
const request=require("request")
const cheerio=require("cheerio")
const  mysql=require('mysql')
var connection = mysql.createConnection({  //配置参数，然后添加你的数据库里面的表
    host: 'localhost',
    user: 'root',
    password: '',
    database: 'tourism'
})
connection.connect();  //连接
var ProvinceName = [
    '北京','天津','上海','重庆','河北','山西','辽宁','吉林','黑龙江',
    '江苏','浙江','安徽','福建','江西','山东','河南','湖北','湖南','广东',
    '海南','四川','贵州','云南','陕西','甘肃','青海','台湾','内蒙',
    '广西','西藏','宁夏','新疆','香港','澳门'
];
//var ProvinceName = [
//    '北京','天津','上海',
//    '江苏'
//];
var PageAtr=[];
var k=0;
//function getPage(){
//    for(var i=0;i<ProvinceName.length;i++)
//    {
//        request('http://s.lvmama.com/ticket/H8P1?keyword='+encodeURI(ProvinceName[i])+'&tabType=ticket#list',function(err,res,req){
//            if(err){
//                console.log('请求出错');
//            }else {
//                var $ = cheerio.load(res.body, {decodeEntities: false});
//                var page= $('.pagebox a').text();
//                if(page.length>7)
//                    PageAtr[k++]=page.substring(6,7);
//                else if(page.length==7){
//                    PageAtr[k++]=page.charAt(6);
//                }else if(page.length<7){
//                    PageAtr[k++]=page.charAt(page.length-1);
//                }
//            }
//        });
//    }
//}
//getPage();
function show(item){
    for(var i=0;i<ProvinceName.length;i++)
    {
        request('http://s.lvmama.com/ticket/H8P1?keyword='+encodeURI(ProvinceName[i])+'&tabType=ticket#list',function(err,res,req){
            if(err){
                console.log('请求出错');
            }else{
                var $ = cheerio.load(res.body, {decodeEntities: false});
                $('.product-list  .product-item').each(function(){

                    var itemHref = $(this).find('.product-regular .product-picture').attr('href');
                    var itemImg = ($(this).find('.product-regular .product-picture img').attr('src')||'0\r0').split('\r')[0];
                    var itemTitle = $(this).find('.product-regular .product-section .product-ticket-title a').text();
                    var itemProvince = $(this).find('.product-regular .product-section .product-ticket-title .city').text();
                    var itemLocal = ($(this).find('.product-regular .product-section .product-details dd').first().text() || '').replace(/[\'\"\\\/\b\f\n\r\t]/g, '');
                    var itemPrice = $(this).find('.product-regular .product-info .product-price em').text();
                    var itemCommentLevel = $(this).find('.product-regular .product-info .product-number b').text();
                    var itemNum = $(this).find('.product-regular .product-info .product-number a').text();
                    //var page= $(this).find('.paging .pagebox a').attr('href');
                    var addSql = "insert into data_scenic(itemHref,itemImg,itemTitle,itemProvince,itemLocal,itemPrice,itemCommentLevel,itemNum) values (?,?,?,?,?,?,?,?)";
                    var addParmas = [ itemHref,itemImg,itemTitle,itemProvince,itemLocal,itemPrice,itemCommentLevel,itemNum];
                    connection.query(addSql,addParmas,function(err,data){
                        if(err){
                            console.log("数据库连接错误");
                        }
                    })
                });
            }
        });
    }
}

show(1)