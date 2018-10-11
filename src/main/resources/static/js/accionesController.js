var AccionesModuleController = function () ({

    var getSymbol = function() {

        let index = document.getElementById("symbol");
        let val = index.value;
        console.log(val);

    }

    return {

        getSymbol:getSymbol

    }

})();