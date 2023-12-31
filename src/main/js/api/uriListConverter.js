define(function() {
    'use strict';

    return {
        read: function(str /*, opts */) {
            return str.split('\n');
        },
        write: function(obj /*, opts */) {
            // If this is an Array, extract the self URI and then join using a newline
            if (obj instanceof Array) {
                return obj.map(resource => resource).join('\n');
            } else { // otherwise, just return the self URI
                return obj;
            }
        }
    };

});