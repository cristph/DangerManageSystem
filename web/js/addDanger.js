/**
 * Created by cristph on 2016/3/18.
 */

$('#createwaiter').click(
    function(){
        var str=new Array('低','中','高');

        var content=document.getElementById("content").value;

        var possiblity;
        var obj=document.getElementsByName("possiblity");
        for(var i=0;i<obj.length;i++) {
            if(obj[i].checked){
                possiblity=str[i];
            }
        }

        var effect;
        var obj2=document.getElementsByName("effect");
        for(var j=0;j<obj2.length;j++) {
            if(obj2[j].checked){
                effect=str[j];
            }
        }

        var limit=document.getElementById("limit").value;
        var poster=document.getElementById("poster").value;
        var tracer=document.getElementById("tracer").value;

        alert(content+"|"+possiblity+"|"+effect+"|"+limit+"|"+poster+"|"+tracer);

        $.post(
            "/addDanger",
            {
                "content":content,
                "possiblity":possiblity,
                "effect":effect,
                "limit":limit,
                "poster":poster,
                "tracer":tracer
            },
            function(data){
                if(data=="success"){
                    alert("新增风险条目成功！");
                    location.href='/postedList';
                }else{
                    alert("未知错误，请重试！");
                }
            });
    }
);
