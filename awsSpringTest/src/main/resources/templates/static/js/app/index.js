var index = {
    init : function () {
        var _this = this;
        $('#btn-save').on('click', function () {
            _this.savePost();
        });

        $('#btn-update').on('click', function(){
            _this.updatePost();
        })
    },
    savePost : function () {
        var data = {
            title : $('#title').val(),
            author : $('#author').val(),
            content : $('#content').val()
        };

        $.ajax({
            type : 'POST',
            url : '/api/v1/posts',
            dataType : 'json',
            contentType : 'application/json; charset=utf-8',
            data : JSON.stringify(data)

        }).done(function() {
            alert('글이 등록 완료 되었습니다.');
            window.location.href = '/';

        }).fail (function (error) {
            alert(JSON.stringify(error));
        });

    };

    updatePost : function () {
        var data = {
            title : $('#title').val(),
            content : $('#content').val()
        };
        var id = $('#id').val();

        $.ajax ({
            type: 'PUT',
            url : 'api/v1/posts/' + id,
            dataType : 'json',
            contentType : 'application/json; charset=utf-8',
            data : JSON.stringify(data)
        }).done (function () {
            alert('글이 수정되었습니다.');
            window.location.href = '/';
        }).fail (function(){
            alert(JSON.stringify(error));
        });
    }
};

index.init();