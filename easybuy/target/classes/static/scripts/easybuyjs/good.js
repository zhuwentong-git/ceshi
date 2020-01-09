$(()=>{

    mingrui.get('good',{typeId:$('input[name="type_id"]').val()},data =>{

        if (data.status == 0){
            let goodHTML='';
            for (let i in data.goodList){
                goodHTML += '<li>\n' +
                    '\t\t\t<dl>\n' +
                    '\t\t\t\t<dt><a href="/product_view?goodId='+data.goodList[i].goodId +'" ><img src="'+ data.goodList[i].goodImg + '" /></a></dt>\n' +
                    '\t\t\t\t<dd class="title"><a href="product-view.html" target="_blank">'+ data.goodList[i].goodName +'</a></dd>\n' +
                    '\t\t\t\t<dd class="price">￥'+ data.goodList[i].goodPrice +'</dd>\n' +
                    '\t\t\t</dl>\n' +
                        '\t\t</li>'

            }
            $('.product').html(goodHTML)
        }

     })
})